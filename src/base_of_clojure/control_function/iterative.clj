(ns base-of-clojure.control-function.iterative)

(loop [i 0]
  false
  (recur (inc i)))

(loop [i 0]
  (when (< i 5)
    (recur (inc i))))

(for [i (range 5)]
  (println i))

(doseq [i (range 5)]
  (println i))

(doseq [i (take-while #(< % 5) (range 10))]
  (println i))

(doseq [i (drop-while #(< % 5) (range 10))]
  (println i))