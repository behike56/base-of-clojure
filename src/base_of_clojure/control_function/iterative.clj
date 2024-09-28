(ns base-of-clojure.control-function.iterative)

(comment
  "loopの例"
  (def factorial
    (fn [n]
      (loop [cnt n acc 1]　;; 1. ループの初期値として cnt = 0, acc = 1 を設定
        (if (zero? cnt)    ;; 2. cnt が 0なら true で、現在のaccを返却
                                          ;; falseで、処理を継続
          acc
          (recur (dec cnt) (* acc cnt))))));; 3. cnt をデクリメントし、accにcntをかけて、再帰的に再評価
  )

(loop [i 0]
  false
  (recur (inc i)))

(loop [i 0]  ;; 1. ループの初期値として i = 0 を設定
  (when (< i 5);; 2. i が 5 未満なら true で、処理を継続
    (println i)
    (recur (inc i))));; 3. i をインクリメントし、再帰的に再評価

(for [i (range 5)]
  (println i))

(doseq [i (range 5)]
  (println i))

(doseq [i (take-while #(< % 5) (range 10))]
  (println i))

(doseq [i (drop-while #(< % 5) (range 10))]
  (println i))