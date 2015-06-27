(defproject serpent-talk2 "0.1.0-SNAPSHOT"
  :description "This is a test"
  :url "http://example.com/test"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.4.0-RC1"]]
  :plugins [[lein-ring "0.9.6"]]
  :ring {:handler project1.core/example-handler
         :init    project1.core/on-init
         :destroy project1.core/on-destroy})
                 
