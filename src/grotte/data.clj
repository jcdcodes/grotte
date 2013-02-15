(ns grotte.data
  (:import java.util.UUID clojure.lang.Keyword)
  )

(def *domains*  (ref {}))
(def *columns*  (ref {}))
(def *rows*     (ref {}))
(def *coltypes* (ref {}))
(def *domain-namers* (ref {}))

(defn truncate-all []
  (dosync
   (ref-set *domains* {})
   (ref-set *columns* {})
   (ref-set *rows*    {})
   (ref-set *domain-namers* {})
   ))

;;;;;;;;;;;;;;
;; Create and destroy (hide) domains (classes)
;;
(defn create-domain
  [^:keyword domain]
  (dosync
   (alter *domains* assoc domain :visible)
   (if (not (get *domain-namers* domain))
     (alter *domain-namers* assoc domain #(str (nth (keys %) 1) ": " (get % (nth (keys %) 1)))))
   (let [old-columns-ref (get @*columns* domain)]
     (if (nil? old-columns-ref)
       (do (alter *columns* assoc domain (ref []))
           (alter *coltypes* assoc domain (ref {}))
           (alter *rows*    assoc domain (ref [])))))))
(defn drop-domain
  [^:keyword domain]
  (dosync (alter *domains* assoc domain :hidden)))
(defn has-domain
  [^:keyword domain]
  (= :visible (get @*domains* domain)))
;;
;;;;;;;;;;;;;;

;;;;;;;;;;;;;;
;; Add and remove columns
;;
(defn add-column
  [^:keyword domain ^:keyword column ^:keyword type]
  (dosync (alter (get @*columns* domain) conj column)
          (alter (get @*coltypes* domain) assoc column type)))

(defn drop-column
  [^:keyword domain ^:keyword column]
  (dosync (alter (get @*columns* domain) (partial remove #(= column %)))
          (alter (get @*coltypes* domain) dissoc column)))

(defn has-column
  [^:keyword domain ^:keyword column]
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
  [^:keyword domain & keys-and-vals]
  (let [newid (UUID/randomUUID)]
    (dosync
     (let [rows-for-domain (get @*rows* domain)
           row (ref (into {:domain domain :id newid} (map vec (partition 2 keys-and-vals))))
           id (:id @row)]
       (if (not (= java.util.UUID (class id)))
         (alter row assoc :id (java.util.UUID/fromString (.toString id))))
       (alter rows-for-domain conj row)
       row))))

(defn find-rows
  ([domain]
     @(get @*rows* domain))
  ([domain ^:keyword column value]
     (filter #(= value (get @% column)) (find-rows domain)))
  ([domain ^:keyword column value & more-columns-and-values]
     (filter (apply find-rows (into [domain] more-columns-and-values)))))

(defn find-row
  [domain ^:keyword column value]
  (first (filter #(= value (get @% column)) (find-rows domain))))
(defn find-row-by-stringid
  [domain ^String id]
  (find-row domain :id (UUID/fromString id)))


(defn update-row
  [domain id ^:keyword column value]
  (let [row (find-row domain :id id)
        prev-row @row]
    (dosync (alter row assoc column value :parent prev-row))))
(defn update-row-by-idstring
  [domain ^String id ^:keyword column value]
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

;;;;;;;;;;;;;;
;; Naming functions
;;
(defn row-name
  "Returns the row's name as determined by its domain's namer function."
  [row]
  (let [domain (:domain row)
        row-namer (get @*domain-namers* domain)]
    (str (row-namer row))))

(defn set-domain-namer
  "Sets the domain's namer function to fn, which takes a row as its argument."
  [domain fn]
  (dosync (alter *domain-namers* assoc domain fn)))

(comment
  "Here is an example:"
  (set-domain-namer :note #(str (:body %) " (" (subs (str (:id %)) 0 8) ")"))

  )

;;
;;;;;;;;;;;;;;
