(ns base-of-clojure.algorithm.search.search-in-strings
  "文字列に対する検索")

;; 1. filter と count を使う方法
(defn count-char
  "文字列 s の中に文字 ch がいくつ含まれるかを返す。
   ;; 使用例
   (count-char \"abracadabra\" \\a)"
  [^String s ch]
  (count (filter #(= % ch) s)))


;; 2. reduce を使う方法
(defn count-char-reduce
  "文字列 s の中に文字 ch がいくつ含まれるかを返す。
   ;; 使用例
   (count-char-reduce \"hello, world!\" \\l)"
  [^String s ch]
  (reduce (fn [cnt c]
            (if (= c ch)
              (inc cnt)
              cnt))
          0
          s))


;; 3. frequencies を使う方法
(defn count-char-freq
  "文字列 s の中に文字 ch がいくつ含まれるかを返す。
   ;; 使用例
   (count-char-freq \"Mississippi\" \\s)"
  [^String s ch]
  (get (frequencies s) ch 0))
