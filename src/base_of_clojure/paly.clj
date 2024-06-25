(ns base-of-clojure.paly)

(defn addition [a b] (+ a b))

(comment 
  (addition 2 5))

(addition 2 5)

(defn message? [str]
  (if (= str "a")
    (print str)
    (print str)))

(message? "b")