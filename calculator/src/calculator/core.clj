(ns calculator.core
  (:require [clojure.test :refer [is are with-test]]))

(with-test
  (defn calc "calculator"
        [op a b]
        (case op
          :+ (+ a b)
          :- (- a b)
          :* (* a b)
          :/ (/ a b)))
  (is (= (calc :+ 1 2) 3))
  (is (= (calc :+ 1 2) 3)))

(def dollar->euro 0.86)

(with-test
  (defn convert-currency [amount currency-in currency-out]
        (case [currency-in currency-out]
          [:dollar :euro] (* dollar->euro amount)
          [:euro :dollar] (* (/ 1 dollar->euro) amount)))
  (is (= (convert-currency 1 :dollar :euro) (* dollar->euro 1)))
  (is (= (convert-currency 1 :euro :dollar) (* (/ 1 dollar->euro) 1))))


(defn currency-units [currency]
  (name currency))

(with-test
  (defn display-currency-conversion [amount currency-in currency-out]
        (let [amount-out (convert-currency amount currency-in currency-out)
              currency-in-units (currency-units currency-in)
              currency-out-units (currency-units currency-out)]
          (str amount " " currency-in-units " is equivalent to: " (format "%.2f" amount-out) " " currency-out-units)))
  (is (= (display-currency-conversion 1 :euro :dollar) "1 euro is equivalent to: 1.16 dollar")))







