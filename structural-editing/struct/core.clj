(ns struct.core)


;; Rules of the game
;; 1. It is forbidden to use the arrow keys
;; 2. It is forbidden to use the mouse
;; 3. You are allowed to open Cursive Cheat sheet or any other structural editing cheat sheet
;; 3. Stay positive. In case of panic, take a couple of deep breaths and smile :)

;; Topic: Structural navigation
;; Mission: write again this piece of code
(defn foo [a b]
      (let [x (+ (* a b))
            y (* a (+ b a))]
           (+ x y)))

;; Topic: Structural navigation
;; Preparation: put the cursor before the opening parenthesis of defn
;; Mission: move the cursor to the opening quote of "Hello Paredit"
;; How many key strokes?
(defn bar [a b]
      (let [x (+ (* a b))
            y (str "Hello Paredit")]
           (+ x y)))


;; Topic: Slurp Forwards
;; transform this code
(+ 12 13)
;; into this code
(let [a 12
      b 13]
     (+ a b))
