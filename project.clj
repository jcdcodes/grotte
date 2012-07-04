(defproject grotte "0.0.1-SNAPSHOT"
  :description "Grotte: Edit-in-place crud schemas and data."
;;  :jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=4321"]
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [ring "1.0.1"]
                 [compojure "1.0.1"]
                 [hiccup "0.3.8"]
                 [enlive "1.0.0"]]
  :main grotte.core)
