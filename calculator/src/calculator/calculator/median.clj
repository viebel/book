(ns calculator.calculator.median
  (:require [clojure.test :refer [deftest is]]))



(defn median [a b c]
  (if (< a b)
    (if (< b c)
      b
      (if (< a c) c a))
    (if (< c b)
      b
      (if (< a c) a c))))

(deftest median-test
  (is (= (median 1 2 3) 2))
  (is (= (median 1 3 2) 2))
  (is (= (median 2 1 3) 2))
  (is (= (median 2 3 1) 2))
  (is (= (median 3 1 2) 2))
  (is (= (median 3 2 1) 2))
  (is (= (median 1 1 2) 1))
  (is (= (median 2 1 1) 1))
  (is (= (median 1 2 2) 2))
  (is (= (median 2 2 1) 2)))

(defn median-2 [a b c]
  (cond
    (<= a b c) b
    (<= a c b) c
    (<= b a c) a
    (<= b c a) c
    (<= c a b) a
    (<= c b a) b))

(deftest median-2-test
  (is (= (median-2 1 2 3) 2))
  (is (= (median-2 1 3 2) 2))
  (is (= (median-2 2 1 3) 2))
  (is (= (median-2 2 3 1) 2))
  (is (= (median-2 3 1 2) 2))
  (is (= (median-2 3 2 1) 2))
  (is (= (median-2 1 1 2) 1))
  (is (= (median-2 2 1 1) 1))
  (is (= (median-2 1 2 2) 2))
  (is (= (median-2 2 2 1) 2)))

(defn median-position [a b c]
  (condp = (median a b c)
    a 1
    b 2
    c 3))

(deftest median-position-test
  (is (= (median-position 10 20 30) 2))
  (is (= (median-position 20 10 30) 1))
  (is (= (median-position 10 30 20) 3)))

