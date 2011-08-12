(ns grotte.test.core
  (:use [grotte.core :as gc])
  (:use [clojure.test]))

(defn seed-data-fixture
  [testfn]

  (gc/create-domain :post)
  (gc/add-column :post :timestamp)
  (gc/add-column :post :body)

  (gc/create-domain :comment)
  (gc/add-column :comment :post)
  (gc/add-column :comment :author)
  (gc/add-column :comment :body)
  (gc/add-column :comment :timestamp)

  (gc/add-row :post :timestamp (java.util.Date.) :body "First p0st.")
  (gc/add-row :post :timestamp (java.util.Date.) :body "Social mobile viral.")
  (gc/add-row :post :timestamp (java.util.Date.) :body "Navel gazing.")

  (testfn)
  )

(use-fixtures :once seed-data-fixture)

(deftest test-has-column
  (is (= 2 (count @gc/*domains*))
      "Didn't manage to seed the data properly.")
  (is (gc/has-column :post :timestamp))
  (is (gc/has-column :post :body))
  (is (gc/has-column :comment :post))
  (is (gc/has-column :comment :author))
  (is (gc/has-column :comment :body))
  (is (gc/has-column :comment :timestamp))
  (is (not (gc/has-column :post :monkey)))
  (is (not (gc/has-column :timestamp :post)))
  (is (not (gc/has-column :post :comment))))

(deftest test-row-ops
  (is (= 2 (count @gc/*rows*)) "Should have Two domains, so two refs in *rows*.")
  (is (= 3 (count @(:post @gc/*rows*))))
  (is (nil? (:monkey @(first @(:post @gc/*rows*)))))
  (is (= "First p0st." (:body @(first @(:post @gc/*rows*)))))
  )

