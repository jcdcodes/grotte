(ns grotte.prevail
  (:import (java.io FileOutputStream File PrintWriter OutputStreamWriter
                    BufferedReader InputStreamReader FileInputStream))
  (:require [clojure.string :as string]))

(def *journal-out* (ref '()))
(defn init-db
  [journal-file-name first-transaction-id]
  (let [creation-time (System/currentTimeMillis)
        filename (str "schmatabase/" first-transaction-id ".journal")
        fos (FileOutputStream. filename)
        journal-out (PrintWriter. (OutputStreamWriter. fos "UTF-8"))
        ]
    (dosync (ref-set *journal-out* journal-out))))


(def *transaction-counter* (atom 0M))

(defn persist-string
  [s]
  (let [out @*journal-out*]
    (.print out (str s \newline))
    (.flush out)))

(defn agent-persist-string
  [a s]
  (persist-string s)
  a)

(def *logger-agent* (agent {}))


(defn serialized-transaction
  [transaction-id & transaction-params]
  (str "(" (string/join " " (map pr-str transaction-params)) ") ;" transaction-id) )

(defmacro prevail
  [f & args]
  `(dosync
    (let [transaction-id# (swap! *transaction-counter* inc)
          the-expr# (serialized-transaction transaction-id# '~f ~@args)
          result# (dosync
                   (~f ~@args)
                   (send-off *logger-agent* agent-persist-string the-expr#))]
      result#)))



