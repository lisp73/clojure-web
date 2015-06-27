(ns serpent-talk.talk
  (:require [camel-snake-kebab.core :as csk]))
;;memo
                                        ;to run this file in the repl, following these steps:
                                        ;1 (require serpent-talk.talk :reload)
                                        ;2 (in-ns serpent-talk.talk)


(defn serpent-talk[input]
  (str "Serpent! You said: "
       (csk/->snake_case input)))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;;use this to run the function in the commandline
(defn -main [& args]
  (println (serpent-talk (first args))))

