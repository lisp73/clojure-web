(ns serpent-talk2.talk2)


(defn example-handler [request]
  {:body "Hello the serpent talks!"})

(defn on-init []
  (println "Initializing your lovely appliaction"))
(defn on-destroy[]
  (println "Destroying your lovely application"))




