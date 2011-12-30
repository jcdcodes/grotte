(ns grotte.prevail
  (:import (java.io FileOutputStream File PrintWriter OutputStreamWriter FileReader PushbackReader
                    BufferedReader InputStreamReader FileInputStream FileNotFoundException))
  (:require [clojure.string :as string]))

(defn load-db
  [journal-file-name]
  (let [filename (str "schmatabase/" journal-file-name ".journal.clj")]
    (with-open [rdr (BufferedReader. (FileReader. filename))]
      (doseq [line (line-seq rdr)]
        (try (eval (read-string line))
          (catch Exception e (println "Failed to read: " line)))))))

(def *journal-out* (ref '()))
(defn init-db
  [journal-file-name first-transaction-id]
  (let [creation-time (System/currentTimeMillis)
        filename (str "schmatabase/" first-transaction-id ".journal.clj")
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
;; Consider adding a write buffer so we're not constantly waiting for the disk.
;; This would mean dropping events on the floor when we crash.

(defn agent-persist-string
  [a s]
  ;;(Thread/sleep 10) ;; use this to make the queue back up so we can watch it drain.
  (persist-string s)
  a)

(def *logger-agent* (agent {}))
;; Recall that (.getQueueCount *logger-agent*) shows you the event queue's size.

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



