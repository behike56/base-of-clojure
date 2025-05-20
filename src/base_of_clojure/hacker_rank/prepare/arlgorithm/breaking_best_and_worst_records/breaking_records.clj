(ns base-of-clojure.hacker-rank.prepare.arlgorithm.breaking-best-and-worst-records.breaking-records)

(defn breaking_records
  "Args: collection
   Returns: collection (2 4)
   Examples:
   [12 23 45 21] => (2 4)"
  [coll]
  (let [maximum (max coll)
        minimum (min coll)]
    ))


(defn max-update-count
  "ベクタ v を先頭から末尾まで走査し、
   最大値が更新された回数を返す。
   空ベクタの場合は 0 を返す。"
  [v]
  (if (empty? v)
    0
    (loop [current-max (first v)
           count      0
           xs         (rest v)]
      (if (empty? xs)
        count
        (let [x   (first xs)
              cnt (if (> x current-max)
                    (inc count)
                    count)
              m   (if (> x current-max)
                    x
                    current-max)]
          (recur m cnt (rest xs)))))))


(defn max-update-count
  "ベクタ v を先頭から末尾まで走査し、
   最大値が更新された回数を返す。"
  [v]
  (if (seq v)
    (second
     (reduce (fn [[current-max cnt] x]
               (if (> x current-max)
                 [x (inc cnt)]
                 [current-max cnt]))
             [(first v) 0]
             (rest v)))
    0))