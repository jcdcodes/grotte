(ns grotte.data
  (:import java.util.UUID))

(def *domains*  (ref {}))
(def *columns*  (ref {}))
(def *rows*     (ref {}))
(def *coltypes* (ref {}))

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
           (alter *coltypes* assoc domain (ref {}))
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
  [^Keyword domain ^Keyword column ^Keyword type]
  (dosync (alter (get @*columns* domain) conj column)
          (alter (get @*coltypes* domain) assoc column type)))

(defn drop-column
  [^Keyword domain ^Keyword column]
  (dosync (alter (get @*columns* domain) (partial remove #(= column %)))
          (alter (get @*coltypes* domain) dissoc column)))

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
  "Creates a new row.  domain must already have been defined. n.b.: If called within grotte.prevail/prevail be sure to specify :id explicitly so the row will have the same :id value upon rehydration from disk."
  [^Keyword domain & keys-and-vals]
  (dosync
   (let [rows-for-domain (get @*rows* domain)
         id (UUID/randomUUID)
         row (ref (into {:domain domain :id id} (map vec (partition 2 keys-and-vals))))]
     (alter rows-for-domain conj row)
     row)))

(defn find-rows
  ([domain]
     @(get @*rows* domain))
  ([domain ^Keyword column value]
     (filter #(= value (get @% column)) (find-rows domain)))
  ([domain ^Keyword column value & more-columns-and-values]
     (filter (apply find-rows (into [domain] more-columns-and-values)))))

(defn find-row
  [domain ^Keyword column value]
  (first (filter #(= value (get @% column)) (find-rows domain))))
(defn find-row-by-stringid
  [domain ^String id]
  (find-row domain :id (UUID/fromString id)))


(defn update-row
  [domain id ^Keyword column value]
  (let [row (find-row domain :id id)
        prev-row @row]
    (dosync (alter row assoc column value :parent prev-row))))
(defn update-row-by-idstring
  [domain ^String id ^Keyword column value]
  (update-row domain (UUID/fromString id) column value))

(defn- set-row-deleted
  [domain id deleted]
  (let [row (find-row domain :id id)]
    (dosync (alter row assoc :deleted deleted))
    @row))

(defn delete-row
  [domain id]
  (set-row-deleted domain id true))

(defn delete-row-by-idstring
  [domain ^String id]
  (delete-row domain (UUID/fromString id)))

(defn undelete-row
  [domain id]
  (set-row-deleted domain id false))

;;
;;;;;;;;;;;;;;
