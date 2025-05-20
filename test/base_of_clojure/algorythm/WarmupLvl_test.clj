(ns base-of-clojure.algorythm.WarmupLvl-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [base-of-clojure.algorythm.WarmupLvl :refer :all]))

((deftest calcHighestCandle-test
   (testing "Context of the test assertions"
     (is (= (calcHighestCandle [4 4 1 3]) 2)))))