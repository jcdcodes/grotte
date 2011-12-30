(ns grotte.core
  (:import java.util.UUID)
  (:require
   [grotte.prevail :as prevail]
   [grotte.data :as data]
   [grotte.web :as web]
   ))

(data/create-domain :post)
(data/add-column :post :body :editable-text)
(data/add-column :post :pubdate :date)
(web/start-server)
(prevail/init-db "1" 1)
(prevail/load-db "base")
