(ns serpent-talk.talk-test
  (:require [clojure.test :refer :all]
            [serpent-talk.talk :refer :all]))

(comment (deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1)))))
;;my first test
(deftest test-serpent-talk
  (testing "Cries serpent! with a snake_case version of the input"
    (is (= "Serpent! You said: hello_there"
           (serpent-talk "hello there")))))


