(ns base-of-clojure.core
  (:require base-of-clojure.file_reader :as fr))

(defn add [a b]
  (+ a b))

(defn -main
  [& args]
  (fr/file_reader (first args))
  
  (add 1 4))
