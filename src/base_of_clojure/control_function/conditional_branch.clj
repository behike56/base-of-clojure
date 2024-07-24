(ns base-of-clojure.control-function.conditional-branch
  "条件分岐")

;; 入力値
(def a 5)
(def b 10)
(def c [1 2 3])
(def d [])

(if (> a b)
  "true: aはbを超える。"
  "false: aはbを超えない。")
;; => "false: aはbを超えない。"

(if (< a b)
  "true: aはbを超える。"
  "false: aはbを超えない。")
;; => "true: aはbを超える。"


(if-not (> a b)
  "true"
  "false")
;; => "true"

(if-not (< a b)
  "true"
  "false")
;; => "false"

;; 複数の式を実行する
(when true
  (let [x (+ a b)]
  (+ b x)))
;; => 25

(when false
  (let [x (+ a b)]
    (+ b x)))
;; => nil


(case (first c)
  1 "This is 1."
  3 "This is 3."
  "Nothing to match.(default)")
;; => "This is 1."

(case (last c)
  1 "This is 1."
  3 "This is 3."
  "Nothing to match.(default)")
;; => "This is 3."

(case (second c)
  1 "This is 1."
  3 "This is 3."
  "Nothing to match.(default)")
;; => "Nothing to match.(default)"


(let [grade 85]
  (cond
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))
;; => "B"

(let [grade 85]
  (cond
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"))
;; => "B"


(if-let [x (first c)]
  (str "vector is not empty. " x)
  "vecor is empty.")
;; => "vector is not empty. 1"

(if-let [x (first d)]
  (str "vector is not empty. " x)
  "vecor is empty.")
;; => "vecor is empty."


;; 条件が真の場合にバインドも行い、複数の式を実行する
(when-let [x (first c)]
  (let [y (+ x 20)]
  (- y 3)))
;; => 18

(when-let [x (first d)]
  (let [y (+ x 20)]
    (- y 3)))
;; => nil

