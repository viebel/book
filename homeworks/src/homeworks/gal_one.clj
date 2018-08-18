
(ns homeworks.gal-one
  (:require [clojure.test :refer [is deftest]]))


;; Lesson 1 HW

(defn nth-element
      "Returns the nth element in a list"
      {:test (fn [] (is (= (nth-element '(2 1 4) 3) 4)))}
      [lst n]
      (if-not (seq lst)
        nil
        (if (= n 1)
          (first lst)
          (nth-element (rest lst) (dec n)))))

(defn rec-select-elements
      "Returns a list with the elements of the original list at given indices position"
      {:test (fn [] (is (= (rec-select-elements (range 4) '(0 2 4)) '(0 2))))}
      [lst indices]
      (if (or (= (count indices) 0) (<= (count lst) (first indices)))
        '()
        (cons (nth lst (first indices)) (rec-select-elements lst (rest indices)))))

(defn select-1-5-7
      "Returns a list with the elements of the original list at position 1 5 and 7"
      {:test (fn [] (is (= (select-1-5-7 (range 10)) '(0 4 6))))}
      [lst]
      (rec-select-elements lst '(0 4 6)))

(defn to-list
      "Converts vector to list"
      {:test (fn [] (is (= (to-list [1 2]) '(1 2))))}
      [vec]
      (if-not (seq vec)
        '()
        (cons (first vec) (to-list (rest vec)))))

(defn present?
      "Returns true or false according to the presence of the \"thing\" in the vector"
      {:test (fn [] (is (= (present? '[1 "a" 3] "a") true)))}
      [vec thing]
      (if-not (seq vec)
        false
        (if (= thing (peek vec))
          true
          (present? (pop vec) thing))))

(defn my-select-keys
      "Returns the values for a selected collection of keys"
      {:test (fn [] (is (= (my-select-keys {:a 1 :b 2} [:a :b :c]) '(1 2 nil))))}
      [m the-keys]
      (if-not (seq the-keys)
        '()
        (cons (get m (first the-keys)) (my-select-keys m (rest the-keys)))))

(defn map-object
      "Returns a map with the same keys as m and with the values transformed by f"
      {:test (fn [] (is (= ((map-object #(* 100 %) {:a 1 :b 2 :c 3}) {:a 100 :b 200 :c 300}))))}
      [f m]
      (if-not (seq m)
        '{}
        (assoc (map-object f (rest m)) (key (first m)) (f (val (first m))))))

(defn rec-sequence-to-map
      "Helper recursive function"
      [s i]
      (if-not (seq s)
        '{}
        (assoc (rec-sequence-to-map (rest s) (inc i)) i (first s))))

(defn sequence-to-map
      "Converts a sequence into a map where the keys are the indexes of the elements in the sequence"
      {:test (fn [] (is (= (sequence-to-map [10 20 30]) {0 10 1 20 2 30})))}
      [s]
      (rec-sequence-to-map s 0))

(defn submap
      "Checks if a map is a submap of the other.
      Map m1 is a submap of m2 if all key/value pairs in m1 exist in m2"
      {:test (fn [] (is (= (submap {:a 1, :b 2, :c 5} {:a 1, :b 2}) false)))}
      [m1 m2]
      (if-not (seq m1)
        true
        (if-not (= (get m2 (key (first m1))) (val (first m1)))
          false
          (submap (rest m1) m2)
          )))

;; Lesson 2

(defn my-acc [res x]
      (let [v (inc (get res x 0))]
        (assoc res x v)))

(defn my-frequencies
      "implements frequencies"
      {:test (fn [] (is (= (my-frequencies ['a 'b 'a 'a]) '{a 3, b 1}))
               (is (= (my-frequencies []) '{})))}
      [coll]
      (reduce my-acc {} coll))

(defn comp-2
      "implement comp"
      {:test (fn [] (is (= ((comp-2 first rest) (range 10)) 1)))}
      [f g]
      (fn [x] (f (g x))))

(defn sum
      "sums up the elements of a sequence using recur"
      {:test (fn [] (is (= (sum [1 2 3]) 6)))}
      [lst]
      (loop [my-lst lst res 0]
        (if (empty? my-lst)
          res
          (recur (rest my-lst)
                 (+ res (first my-lst))))))

(defn count-multi
      ""
      {:test (fn []
               (is (= 0 (count-multi)))
               (is (= 1 (count-multi 1)))
               (is (= 5 (count-multi 1 2 3 4 5))))}
      ([] 0)
      ([& args] (inc (apply count-multi (rest args)))))


(defmacro dbg[x]
  (when *assert*
    `(let [x# ~x]
       (println (str '~x " => " x#))
       x#)))

(let [s "hi"]
  (dbg s))
