(ns base-of-clojure.sequences.seq-practice)


(def vec_a [2 4 6 7 10 13 17])
(def vec_b [1 3 5 8 9 11 12 14 15 16])
(def list_a '(1 2 3 4 5))
(def map_a {:name "Alpha" :age 33 :gender "male"})
(def set_a #{10 20 30 40 50})

(first vec_a)
;; => 2
(first list_a)
(first map_a)
(first set_a)
(first [])
;; => nil

(rest vec_a)
;; => (4 6 7 10 13 17)
(rest [])
;; => ()
(rest '())
;; => ()
(rest {})
;; => ()
(rest #{})
;; => ()

(cons 1 vec_b)
;; => (1 1 3 5 8 9 11 12 14 15 16)
(cons vec_a vec_b)
;; => ([2 4 6 7 10 13 17] 1 3 5 8 9 11 12 14 15 16)

(seq vec_a)
;; => (2 4 6 7 10 13 17)
(seq [])
;; => nil

(next vec_a)
;; => (4 6 7 10 13 17)
(next [])
;; => nil
(next '())
;; => nil
(next {})
;; => nil
(next #{})
;; => nil

(next '("a" "b"))
;; => ("b")
