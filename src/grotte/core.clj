(ns grotte.core
  (:import java.util.UUID))

(defonce *domains* (ref {}))
(defonce *columns* (ref {}))
(defonce *rows*    (ref {}))

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
;;
;;;;;;;;;;;;;;

;;;;;;;;;;;;;;
;; Row operations
;;
(defn add-row
  [^Keyword domain & keys-and-vals]
  (dosync
   (let [rows-for-domain (get @*rows* domain)
         row (ref (merge {:domain domain} (into {} (map vec (partition 2 keys-and-vals)))))]
     (alter rows-for-domain conj row)
     row)))

;;(defn update-row)
(defn update-row
  [row ^Keyword column value]
  (dosync (alter row assoc column value)))

;;(defn delete-row)
(defn delete-row
  [row]
  (dosync (alter row assoc :deleted true)))
;;
;;;;;;;;;;;;;;
