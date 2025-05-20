(ns base-of-clojure.algorythm.sort.big-sorting-test
  (:require
  [clojure.test :refer [deftest is testing]] 
  [base-of-clojure.algorythm.sort.sorting :refer [bigSorting]]))

(def unsorted [6
               31415926535897932384626433832795
               1
               3
               10
               3
               5])

(deftest bigSortin-test
  (testing ""
    (is (not= ["1" "3" "3" "5" "6" "10" "31415926535897932384626433832795"]
              (bigSorting unsorted)))))