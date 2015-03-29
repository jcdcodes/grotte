(defproject grotte "0.0.1-SNAPSHOT"
  :description "Grotte: Edit-in-place crud schemas and data."
;;  :jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=4321"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 ;[org.clojure/clojure-contrib "1."]
                 [org.clojure/data.json "0.2.3"]
                 [ring "1.3.2"]
                 [compojure "1.3.2"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.5"]]
  :main grotte.core)
