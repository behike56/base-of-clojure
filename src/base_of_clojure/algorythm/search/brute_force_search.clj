(ns base-of-clojure.algorythm.search.brute-force-search
  "全検索
   定義
   全探索（Brute-Force Search）は、解の候補となり得るすべてのパターン・組み合わせを列挙し、条件を満たすかを順に調べる手法です。
   
   特徴
   実装がシンプル
   入力サイズが小さい場合には十分実用的
   最悪ケースの計算量は探索空間の大きさに依存して指数的に増大"
  (:require [clojure.string :as str]))


(defn power-set
  "部分集合（べき集合）の列挙
   与えられたコレクション coll のすべての部分集合を列挙する
   再帰的に「先頭要素を含まない部分集合」と「含む部分集合」を生成して結合計算量は O(2^n)"
  [coll]
  (if (empty? coll)
    ;; 空コレクションの部分集合は [[]]
    (list '())
    (let [rest-ps (power-set (rest coll))]
      ;; 各部分集合に、(first coll) を付加したものを追加
      (concat rest-ps
              (map #(cons (first coll) %) rest-ps)))))