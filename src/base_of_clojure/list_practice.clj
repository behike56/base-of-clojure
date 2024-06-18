(ns base-of-clojure.list-practice)

;;;; Lists Related Functions
;;; Related functions
;;; Create a list: list list*
;;; Treat a list like a stack: peek pop
;;; Examine a list: list?

(defn make_list
  "range: 第1引数から、第2引数まで(`num`)の整数を順番に返す。"
  [num]
  (range 1 num))

(defn make_repeat_list
  "repeat: 引数に与えられた要素を繰り返したリストを返す。"
  [str]
  (repeat 4 str))

(defn make_repeatedly_list
  "repeatedly: 無限（与えられた場合は長さn）の遅延呼び出しシーケンスを返す。"
  [limit]
  (repeatedly limit #(rand-int 11)))