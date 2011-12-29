(ns grotte.core
  (:import java.util.UUID)
  (:require
   [grotte.prevail :as prevail]
   [grotte.data :as data]
   [grotte.web :as web]
   ))

(data/create-domain :post)
(data/add-column :post :body :editable-text)
