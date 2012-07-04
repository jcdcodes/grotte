(defproject grotte "0.0.1-SNAPSHOT"
  :description "Grotte: Edit-in-place crud schemas and data."
;;  :jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=4321"]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 ;[org.clojure/clojure-contrib "1."]
                 [ring "1.1.1"]
                 [compojure "1.1.0"]
                 [hiccup "1.0.0"]
                 [enlive "1.0.1"]]
  :main grotte.core)
