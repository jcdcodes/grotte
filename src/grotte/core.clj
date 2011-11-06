(ns grotte.core
  (:import java.util.UUID)
  (:require [grotte.web :as web]
            [grotte.data :as data]
            [grotte.prevail :as prevail]))

(grotte.data/create-domain :post)
(grotte.data/add-column :post :body :editable-text)
