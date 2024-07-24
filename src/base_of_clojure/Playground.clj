(ns base-of-clojure.Playground
  (:require
   [base-of-clojure.algorythm.WarmupLvl :as wul]))

;; 入力値
(def array [1 3 5 7 9 11 13])
(def array2 [8 4 9 1 7 2 5 3])
(def candles [2 1 5 8 8 2])
(def time-str1 "12:01:00PM")
(def time-str2 "12:01:00AM")

;; 関数呼び出し
(wul/sharpcase 6)

(wul/sumMinMax array2)

(wul/calcHighestCandle candles)

(wul/convertTime12to24 time-str1)
(wul/convertTime12to24 time-str2)


;; ビルトイン関数の動作確認
(doseq [x array]
  (println x))
;;; 関数定義
(defn addition [a b] (+ a b))
;;; コメントでの関数呼び出し
(comment
  (addition 2 5))
;; => nil


(addition 2 5)
;; => 7

(defn message? [str]
  (if (= str "a")
    (print str)
    (print str)))

(message? "b")

(range 7)
;; => (0 1 2 3 4 5 6)

(repeat 4 "a")
;; => ("a" "a" "a" "a")

(apply str (repeat 4 "a"))
;; => "aaaa"


; ベクタのソート方法
;; sort: 昇順にソートする
(sort array2)
;; sort-by関数はソートのキーと比較関数を指定することができ、
;; ここではidentity関数をキーに、>を比較関数として降順にソートしています。
(sort-by identity > array)
;; => (13 11 9 7 5 3 1)

(sort-by identity < array)
;; => (1 3 5 7 9 11 13)

; ベクタの先頭を取り除く
;;subvec関数は、引数として開始インデックスとオプションの終了インデックスを取ります。
;; 開始インデックスから終了インデックスの間の要素を含む部分ベクタを返します。
(subvec array 1)
; ベクタの最後尾を取り除く
;; subvec関数は、部分ベクタを作成するために
;; 開始インデックスと終了インデックスを取ります。
;; 開始インデックスは0、終了インデックスは(dec (count vec))とすることで、
;; ベクタの最後の要素を除いた部分を取得します。
(subvec array 0 (dec (count array)))

(reduce + (subvec (vec (sort array2)) 1))
(reduce + (subvec (vec (sort array2)) 0 (dec (count array2))))
; ベクタの作成方法
(print (vec [38 30]))

; max関数は2つ以上の数値を受け取り、その中で最大の数値を返します。
; apply関数は、引数として関数とコレクションを取り、
;そのコレクションの各要素を関数に渡します。
;この場合、max関数にベクタの要素をすべて渡して最大値を求めます。
(apply max array2)

; filter関数は、コレクションの各要素に対して述語関数を適用し、その結果が真である要素のみを含むシーケンスを返します。
; この場合、述語関数#(= % target)は、各要素がtargetと等しいかどうかをチェックします。
; count関数は、シーケンスの要素数を数えます。filter関数で返されたシーケンスの要素数を数えることで、
; ベクタの中で特定の整数が何個あるかを求めます。
(count (filter #(= % 9) array2))


(let [[_ hour min sec period] (re-matches #"(\d{2}):(\d{2}):(\d{2})(AM|PM)" time-str)
      ])

(Integer/parseInt "33")
;; => 33

(format "%02d" 3)
;; => "03"

(cond (and true false) "00"
      (and false true) "01"
      :else "ELSE")
;; => "ELSE"
