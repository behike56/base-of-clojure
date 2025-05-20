(ns base-of-clojure.algorythm.sort.sorting)

(defn bigSorting
  "1 ~ 10^6の値を想定。
   文字列として比較を行う。
   桁数の比較を行い、同じ桁数の場合、`compare`関数を使用。
   "
  [unsorted]
  (sort-by
   (juxt (comp count str) str)
   unsorted))
