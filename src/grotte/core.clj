(ns grotte.core
  (:import java.util.UUID))

(def *domains* (ref {}))
(def *columns* (ref {}))
(def *rows*    (ref {}))

(defn truncate-all []
  (dosync
   (ref-set *domains* {})
   (ref-set *columns* {})
   (ref-set *rows*    {})
   ))

;;;;;;;;;;;;;;
;; Create and destroy (hide) domains (classes)
;;
(defn create-domain
  [^Keyword domain]
  (dosync
   (alter *domains* assoc domain :visible)
   (let [old-columns-ref (get @*columns* domain)]
     (if (nil? old-columns-ref)
       (do (alter *columns* assoc domain (ref []))
           (alter *rows*    assoc domain (ref [])))))))
(defn drop-domain
  [^Keyword domain]
  (dosync (alter *domains* assoc domain :hidden)))
;;
;;;;;;;;;;;;;;

;;;;;;;;;;;;;;
;; Add and remove columns
;;
(defn add-column
  [^Keyword domain ^Keyword column]
  (dosync (alter (get @*columns* domain) conj column)))

(defn drop-column
  [^Keyword domain ^Keyword column]
  (dosync (alter (get @*columns* domain) (partial remove #(= column %)))))

(defn has-column
  [^Keyword domain ^Keyword column]
  (let [columns-ref (domain @*columns*)]
    (if (not (nil? columns-ref))
      (some #(= % column) @columns-ref))))
;;
;;;;;;;;;;;;;;

;;;;;;;;;;;;;;
;; Row operations
;;
(defn make-row
  [^Keyword domain & keys-and-vals]
  (dosync
   (let [rows-for-domain (get @*rows* domain)
         row (ref (merge {:domain domain :id (UUID/randomUUID)}
                         (into {} (map vec (partition 2 keys-and-vals)))))]
     (alter rows-for-domain conj row)
     row)))

(defn update-row
  [domain id ^Keyword column value]
  (let [row (first (filter #(= id (str (:id @%))) @(get @*rows* domain)))]
    (dosync (alter row assoc column value))))

(defn- set-row-deleted
  [domain id deleted]
  (let [row (first (filter #(= id (:id @%)) @(get @*rows* domain)))]
    (dosync (alter row assoc :deleted deleted))
    @row))

(defn delete-row
  [domain id]
  (set-row-deleted domain id true))

(defn undelete-row
  [domain id]
  (set-row-deleted domain id false))

;;
;;;;;;;;;;;;;;
