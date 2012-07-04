(ns grotte.core
  (:require
   [grotte.prevail :as prevail]
   [grotte.data :as data]
   [grotte.web :as web]
   ))

(defn -main
  [& args]
  (data/create-domain :post)
  (data/add-column :post :body :editable-text)
  (data/add-column :post :pubdate :date)
  (web/start-server)
  (prevail/load-db "base")
  (prevail/init-db "base" 1) ;;Clearly need to be smarter about transaction number.
  )
