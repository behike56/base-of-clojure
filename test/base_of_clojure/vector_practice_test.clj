(ns base-of-clojure.vector-practice-test
  (:require
  [clojure.test :refer :all]
  [base-of-clojure.sequences.vector-practice :refer :all]))

(deftest make_vec-test
  (testing "vectorのテスト"
    (is (= [4 5 6 [1 2 3]] (make_vec [1 2 3])))))

(deftest make_vec2-test
  (testing "vecのテスト。"
    (is (= [1 2 3] (make_vec2 '(1 2 3))))
    (is (= [1 2 3] (make_vec2 (sorted-set 1 2 3))))
    (is (= [[:a 1] [:b 2] [:c 3]] (make_vec2 {:a 1 :b 2 :c 3})))))

(deftest make_vec3-test
  (testing "vector-ofのテスト"
    (is (= [1 2 3] (make_vec3 :int)))))

;;;  Examine a vector

(deftest examine_vec1-test
  (testing "getのテスト"
    (is (= 10 (examine_vec1 4)))))

(deftest examine_vec1-1-test
  (testing "getのテスト"
    (is (= "not-found" (examine_vec1-1 5)))))

(deftest examine_vec2-test
  (testing "nthのテスト"
    (is (= 6 (examine_vec2 2)))))

(deftest examine_vec3-test
  (testing "peekのテスト"
    (is (= 4 (examine_vec3 [1 2 3 4])))))

(deftest examine_vec4-test
  (testing "rseqのテスト"
    (is (= '(9 8 7 6 5 4 3 2 1 0) (examine_vec4 (vec (range 10)))))))

(deftest examine_vec5-test
  (testing "vector?のテスト"
    (is (= true (examine_vec5 [0])))))

;;; 'change' a vector: assoc pop subvec replace

(deftest change_assoc_vector1-test
  (testing "assocのテスト"
    (is (= {:key1 "old value1" :key2 "value2" :key3 "valuje3"} (change_assoc_vector1 {:key1 "old value1" :key2 "value2"} :key3 "valuje3")))))

(deftest change_assoc_vector2-test
  (testing "assocのテスト"
    (is (= {:key1 {:key2 "abc"}} (change_assoc_vector2 {} :key1 {:key2 "abc"})))))

(deftest change_pop_vector-test
  (testing "popのテスト"
    (is (= [1 2] (change_pop_vector [1 2 3])))))

(deftest change_subvec_vector1-test
  (testing "subvecのテスト"
    (is (= [3 4 5 6 7]  (change_subvec_vector1 [1 2 3 4 5 6 7] 2)))))

(deftest change_subvec_vector2-test
  (testing "subvecのテスト"
    (is (= [3 4] (change_subvec_vector2 [1 2 3 4 5 6 7] 2 4)))))

(deftest change_replace_vector-test
  (testing "replaceのテスト"
    (is (= [10 8 6] (change_replace_vector [10 9 8 7 6] [0 2 4])))))

(run-tests)
