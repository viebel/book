(def summaries ["cold" "moderate"])  ;; creates a vector with two strings: "cold" and "moderate"
(def new-summaries (assoc summaries 2 "hot")) ;; creates a new vector with an additional string: "hot"

(defn celsius->farenheit [c] ;; define a function that converts from celsius to farenheit
  (+ 32 (* c 9/5))) ; c * 9/5 + 32

(defn celsius->summary [c] ;; define a function that converts from celsius to summary
  (if (and (>= c 6)        ;; when c is between 6 and 25, it's moderate
           (< c 25))
    (nth new-summaries 1)
    (if (>= c 25)
      (nth new-summaries 2) ;; when c is above 25, it's hot
      (nth new-summaries 0))))  ;; otherwise it's cold

(defn main[]                 ;; define the main function
  (doseq [c (range -8 43 5)] ;; go over all the numbers between -8 (included) and 43 (excluded) with steps of 5
    (let [f (celsius->farenheit c)    ;; create local bindings with f and summary
          summary (celsius->summary c)]
      (println c " celsius is " f " farenheit, " summary)))) ;; print the celsius and its 2 conversions

(main)                       ;; call the main function
