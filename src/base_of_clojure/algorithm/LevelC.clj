(ns base-of-clojure.algorythm.LevelC
  (:require [clojure.string :as str]))

(defn newline-digit-step4
  []
  (let [num-list '(813 1 2 923874 23648 782356 3256 2342 24324 112)]
    (doseq [num num-list]
      (println num))))

(defn newline_digit_boss
  "1 以上 1,000 以下の整数を昇順で、すべて改行区切りで出力してください。"
  []
  (let [end 1000]
    (doseq [num (range 1 (+ end 1))]
      (println num))))

(defn space_oneline_step1
  "2 つの 1 を半角スペース区切りで出力してください。"
  []
  (println (str "1" " " "1")))

(defn space_oneline_step2
  "3 つの数値 8, 1, 3 を半角スペース区切りで出力してください。"
  []
  (println (str 8 " " 1 " " 3)))

(defn space_oneline_step3
  "1 から 10 までの数値をすべて、出力してください。
   ただし、数値の後には必ず半角スペースを出力してください。"
  []
  (let [num-list (range 1 11)
        pre-str (str/join " " num-list)]
    (println (str pre-str " "))))

(defn space_oneline_boss
  []
  (let [num-list (range 1 11)
        pre-str (str/join " " num-list)]
    (println pre-str)))

(defn string_output_step4
  "10 個の文字列 S_1, S_2, S_3, ..., S_10 が改行区切りで与えられます。
   これらの文字列をすべて、半角スペース区切りで出力してください。"
  []
  (let [words (for [i (range 11)] (read-line))
        pre-str (str/join " " words)]
    (println (apply str (drop-last pre-str)))))

;; (defn string_output_step4
;;   []
;;   (let [words (for [i (range 11)] (read-line))]
;;   (doseq [word words]
;;     (println word))))

(defn string_output_boss
  []
  (let [input (read-line)
        str-list (str/split input #" ")]
    (doseq [str str-list]
      (println str))))

(defn n_line_step1
  "数値 N (N = 1 または 2) が入力されます。N = 1 の場合は 1 を、N = 2 の場合は 1 と 2 を改行区切りで出力してください。"
  []
  (let [input (Integer/parseInt (read-line))
        num-list (for [i (range 1 (+ input 1))] i)]
    (doseq [num num-list]
      (println num))))

(defn n_line_step2
  "数値 N が入力されます。1 から N までの数値をすべて、改行区切りで出力してください。"
  []
  (let [input (Integer/parseInt (read-line))
        num-list (for [i (range 1 (+ input 1))] i)]
    (doseq [num num-list]
      (println num))))

(defn n_line_boss
  "数値 N が入力されます。1 から N までの数値をすべて、改行区切りで出力してください。"
  []
  (let [input (Integer/parseInt (read-line))
        num-list (for [i (range 1 (+ input 1))] i)]
    (doseq [num num-list]
      (println num))))


; カンマ区切りで 2 つ出力

(defn specific_split_step1
  "2 つの数値が半角スペース区切りで与えられます。これらの数値をカンマ区切りで出力してください。"
  []
  (let [input (read-line)]
    (println (str/replace input " " ","))))

(defn specific_split_step2
  "3 つの文字列が改行区切りで与えられます。
   これらの文字列をバーティカルライン | 区切りで出力してください。"
  []
  (let [input-s1 (read-line)
        input-s2 (read-line)
        input-s3 (read-line)]
    (println (str input-s1 "|" input-s2 "|" input-s3))))

(defn specific_split_step3
  "10 個の数値が半角スペース区切りで与えられます。これらの数値すべて受け取り、そのまま出力してください。
   ただし、数値を出力した直後に必ずカンマを、末尾にはさらに改行も出力してください。"
  []
  (let [input (read-line)]
    (println (str (str/replace input " " ",") ","))))

(defn specific_split_step4
  "10 個の数値が半角スペース区切りで与えられます。これらの数値をカンマ区切りで出力してください。
   ただし、末尾にはカンマではなく改行を出力してください。"
  []
  (let [input (read-line)]
    (println (str/replace input " " ","))))

(defn specific_split_step5
  "10 個の数値が改行区切りで与えられます。これらの数値を半角スペース 2 つとバーティカルライン | 区切りで出力してください。
   ただし、末尾には改行を出力してください。"
  []
  (let [input (for [i (range 1 11)] (read-line))
        join-str (str/join " | " input)]
    (println join-str)))


(defn specific_split_step6
  "大きな数値 N が入力されます。3 けたごとにカンマ区切りで出力してください。
   ただし、N のけた数は 3 の倍数です。"
  []
  (let [input (read-line)]
    (->> input
         reverse
         (partition-all 3)      ;; n 個ずつのシーケンスに分割
         (map (comp str/join reverse))  ;; 各シーケンスを元の向きに戻して文字列化
         reverse                ;; チャンクの順序を逆に
         (str/join ",")
         println)))

; 3 * 3 の出力
(defn two_dim_array_step2
  "9 個の数値が半角スペース区切りで入力されます。この数値を 3 行 3 列の形式で出力してください。
   具体的には、入力された数値を N_1 , N_2 , N_3 , ..., N_9 とするとき、 1 行目にはN_1 からN_3 を、
   2 行目には N_4 から N_6 を、3 行目には N_7 から N_9 を出力してください。
   ただし、数値の間には半角スペースを、各行の末尾には、半角スペースの代わりに改行を入れてください。"
  []
  (let [input (read-line)
        str-vec (str/split input #"\s+")]
    (->> str-vec
         (partition-all 3)
         (mapv vec)
         (#(doseq [inner %]
             (println (str/join " " inner)))))))

(defn two_dim_array_step3
  "九九表を出力してください。具体的には、出力のi行j列目 (1 ≦ i, j ≦ 9) の数値は i * j になるように出力してください。
   ただし、数値の間には半角スペースを、各行の末尾には、半角スペースの代わりに改行を入れてください。"
  []
  (let [result (map (fn [x]
                      (map (fn [y]
                             (* x y))
                           (range 1 10)))
                    (range 1 10))]
    (doseq [num result]
      (println (str/join " " num)))))

(defn two_dim_array_boss
  "自然数 N が入力されます。N 行 N 列の九九表を出力してください。
   具体的には、出力の i 行 j 列目 (1 ≦ i, j ≦ N ) の数値は i * j になるように出力してください。"
  []
  (let [n (Integer/parseInt (read-line))
        result (map (fn [x]
                      (map (fn [y]
                             (* x y))
                           (range 1 (+ n 1))))
                    (range 1 (+ n 1)))]
    (doseq [num result]
      (println (str/join " " num)))))

(defn variable_array_step1
  []
  (let [input (Integer/parseInt (read-line))
        first-line (str/join " " (range 1 (+ (quot input 2) 1)))
        second-line (str/join " "  (range  (+ (quot input 2) 1) (+ input 1)))]
    (println first-line)
    (println second-line)))

(defn variable_array_step2
  "(require '[clojure.string :as str])"
  []
  (let [input (read-line)
        str-list (str/split input #" ")]
    (println (str/join " " (range 1 (+ (Integer/parseInt (first str-list)) 1))))
    (println (str/join " " (range 1 (+ (Integer/parseInt (second str-list)) 1))))
    ))