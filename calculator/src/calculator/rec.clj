(ns calculator.rec
  (:import (sun.reflect.generics.tree FieldTypeSignature)))



(defn new-rect [x y]
  {:x         x
   :y         y
   :calc-area (fn [rect]
                (* (:x rect)
                   (:y rect)))})


(def my-rectangle (new-rect 9 8))

((:calc-area my-rectangle) my-rectangle)



(def rect-2 (assoc my-rectangle :x 9990))
((:calc-area rect-2) rect-2)


(defn run-method [obj method-key]
  ((method-key obj) obj))

(run-method (assoc my-rectangle :x 181818) :calc-area)


(defprotocol Figure
  (update-width [this new-width])
  (calc-area [this]))

(defrecord Rect [width height]
  Figure
  (update-width [rect new-width] (Rect. :width new-width :height height) #_(assoc rect :width new-width))
  (calc-area [rect] (* width height)))


(defrecord Square [side]
  Figure
  (calc-area [_] (* side side)))

(calc-area (Rect. 10 98))

(def a (Rect. 10 9))

(calc-area a)

(assoc a :width 98)


(update-width (Rect. 100 100) 98)


(calc-area (Square. 100))
(update-width (Square. 9) 1000)