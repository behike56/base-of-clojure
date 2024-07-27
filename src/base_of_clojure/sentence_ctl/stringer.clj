(ns base-of-clojure.sentence-ctl.stringer)
(comment
  "文字列の切り取り"
  (def input_str "36")

  (subs input_str 0 1)
  ;; => "3"
  (subs input_str 1)
  ;; => "6"
  )


(comment
  "文字列の結合"
  (def input_strA "abc")
  (def input_strB "123")

  (str input_strA input_strB)
  ;; => "3"
  (subs input_str 1)
  ;; => "6"
  )
(str "abc" "123")

