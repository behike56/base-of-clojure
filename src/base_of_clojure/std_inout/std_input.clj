(ns base-of-clojure.std-inout.std-input
  "標準入力の受け取り方。"
  (:require [clojure.string :as str]))


(def lines (line-seq (java.io.BufferedReader. *in*)))
(doseq [line lines]
  (println line))

(def input-line (read-line))
(def values (str/split input-line #"\s+"))

; java.lang.Integer.parseInt
(defn read-int []
  (Integer/parseInt (read-line)))

(doseq [value values]
  (println value))

(map println [1 2 3])


(doseq [i (range 1 20)]
  (println "処理番号:" i))

(defn zoro-nums [x]
  (cond (<= x 21) 11
        (<= x 32) 22
        (<= x 43) 33
        (<= x 54) 44
        (<= x 65) 55
        (<= x 76) 66
        (<= x 87) 77
        (<= x 98) 88
        (= x 99) 99
        :else 0))

(print (zoro-nums (java.lang.Integer/parseInt 70)))