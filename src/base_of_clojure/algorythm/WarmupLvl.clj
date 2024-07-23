(ns base-of-clojure.algorythm.WarmupLvl)

(defn sharpcase
  "底辺と高さはともにnに等しく、#記号と空白を使って描かれる。
   最後の行には空白を入れない。
   大きさ n の階段を表示する。
   
   [i (range 1 (inc n))] で、i を 1 から n までの範囲で繰り返します。
   (inc n) は n に 1 を加えたものです。
   つまり、range 1 (inc n) は 1 から n までの範囲の数を生成します。"
  [n]
  (doseq [i (range 1 (inc n))] ; 
    (let [space (apply str (repeat (- n i) " "))
          star (apply str (repeat i "#"))]
      (println (str space star)))))

(defn sumMinMax
  "5つの正の整数が与えられたとき5つの整数のうちちょうど
   4つの整数の和で計算できる最小値と最大値を求めよ
   そして，それぞれの最小値と最大値を，
   スペースで区切られた2つの長い整数からなる1行として表示せよ"
  [arr]
  (print
   (reduce + (subvec (vec (sort arr)) 0 (dec (count arr))))
   (reduce + (subvec (vec (sort arr)) 1))))

(defn calcHighestCandle
  "あなたは子供の誕生日のケーキを担当します。 
   ケーキのろうそくは、その子の年齢の合計ごとに1本と決めている。
   一番高いロウソクを吹き消すことができる。
   一番背の高いロウソクが何本あるか数えてください。

   ex: candles [4 4 1 3]"
  [candles]
;;   (count (filter #(= % (apply max candles)) candles))
  (let [max-val (apply max candles)]
    (reduce (fn [count candle]
              (if (= candle max-val)
                (inc count)
                count))
            0
            candles)))

(defn convertTime12to24
  "AM/PMの12時間表示の時刻をミリタリータイム（24時間表示）に変換する。
  
  注: - 12時間時計の12:00:00AMは、24時間時計の00:00:00である。
  - 12時間時計の12:00:00PMは、24時間時計の12:00:00である。
   
   '12:01:00PM' Return '12:01:00'
   '12:01:00AM' Return '00:01:00'"
  [time-str]
  (let [[_ hour min sec period] (re-matches #"(\d{2}):(\d{2}):(\d{2})(AM|PM)" time-str)
        hour-int (Integer/parseInt hour)
        military-hour (cond
                        (and (= period "AM") (= hour-int 12)) "00"
                        (and (= period "AM") (not= hour-int 12)) (format "%02d" hour-int)
                        (and (= period "PM") (= hour-int 12)) "12"
                        :else (format "%02d" (+ hour-int 12)))]
    (str military-hour ":" min ":" sec)))