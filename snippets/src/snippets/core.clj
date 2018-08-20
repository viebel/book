(ns snippets.core
  (:require [clojure.set :refer [intersection] :rename {intersection ii}]))




(comment
  (ii #{1 2} #{1 4}))


(defn foo
  "I don't do a whole lot."
  [x y]
  (println x "Hello, World!"))


(comment (if (> x 2)
           3
           (if (< x 10)
                (+ x  20)
                (+ x 10)))

         (+ (* 2 3)
            (* 5 7)))

(defn bar [a b] a)

(foo 1 
     (bar 2 3))
(foo 1 2)

(comment
  (+ 2 3)
  (> x 2)
  (if (> x 2)
    3
    5)
  (+ 2 3)
  (> x 2))

