(ns base-of-clojure.vector-list-test
  (:require
  [clojure.test :refer :all]
  [base-of-clojure.vector-list :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= [4 5 6] (make_vec [1 2 3])))))

(deftest make_list-test
  (testing ""
    (is (= (list 1 2 3 4 5 6 7 8 9) (make_list 10)))))

(deftest make_repeat_list-test
  (testing ""
    (is (= (list "apple" "apple" "apple" "apple") (make_repeat_list "apple")))))

(deftest test-make_repeatedly_list
  (testing "make_repeatedly_list function"
    ;; テスト1: リストの長さが指定されたlimitと同じであることを確認します。
    (let [limit 5
          result (make_repeatedly_list limit)]
      (is (= limit (count result)) "The length of the result should be equal to the limit"))

    ;; テスト2: リスト内のすべての要素が0から10の範囲内であることを確認します。
    (let [limit 10
          result (make_repeatedly_list limit)]
      (is (every? #(and (integer? %) (<= 0 %) (<= % 10)) result) "All elements should be integers in the range 0 to 10"))

    ;; テスト3: リストが空であることを確認します（limitが0の場合）。
    (let [limit 0
          result (make_repeatedly_list limit)]
      (is (empty? result) "The result should be an empty list when limit is 0"))))
