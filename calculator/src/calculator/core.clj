(ns calculator.core
  (:require [clojure.test :refer [deftest is are]]))

(defn foo [x]
  (* x 999))

(defn calc "calculator"
  {:test #(do
            (is (= (calc :+ 1 2) 3)))}
    [op a b]
  (case op
    :+ (+ a b)
    :- (- a b)
    :* (* a b)
    :/ (/ a b)))

(def dollar->euro 0.86)

(defn convert-currency [amount currency-in currency-out]
  (case [currency-in currency-out]
    [:dollar :euro] (* dollar->euro amount)
    [:euro :dollar]  (* (/ 1 dollar->euro) amount)))


(defn currency-units [currency]
  (name currency))

(defn display-currrency-conversion [amount currency-in currency-out]
  (let [amount-out (convert-currency amount currency-in currency-out)
        currency-in-units (currency-units currency-in)
        currency-out-units (currency-units currency-out)]
    (str amount " " currency-in-units " is equivalent to: " (format "%.2f" amount-out) " " currency-out-units)))

(deftest calc-test
  (assert (= (calc :+ 1 2) 3)))

(deftest convert-currency-test
  (is (= (convert-currency 1 :dollar :euro) (* dollar->euro 1)))
  (is (= (convert-currency 1 :euro :dollar) (* (/ 1 dollar->euro) 1))))

(deftest display-currrency-conversion-test
  (is (= (display-currrency-conversion 1 :euro :dollar) "1 euro is equivalent to: 1.16 dollar")))






