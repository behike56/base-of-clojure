(ns base-of-clojure.core
  (:require base-of-clojure.file_reader :as fr))

(defn -main
  [& args]
  (fr/file_reader (first args)))
