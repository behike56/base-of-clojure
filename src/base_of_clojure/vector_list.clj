(ns base-of-clojure.vector-list)

(defn make_vec
  "vector: 与えられた引からベクター型を作成する。"
  [vec]
  (vector 4 5 6 vec))

(defn make_list
  "range: 第1引数から、第2引数まで(`num`)の整数を順番に返す。"
  [num]
  (range 1 num))

(defn make_repeat_list
  "repeat: 引数に与えられた要素を繰り返したリストを返す。"
  [str]
  (repeat 4 str))

(defn make_repeatedly_list
  ""
  [limit]
  (repeatedly limit #(rand-int 11)))