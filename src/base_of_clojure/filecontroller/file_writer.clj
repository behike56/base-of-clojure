(ns base-of-clojure.filecontroller.file-writer
  (:require  [clojure.data.csv :as csv]
             [clojure.java.io :as io]))

(defn maps-to-csv [data filepath]
  (let [header (keys (first data))
        rows (map vals data)]
    (with-open [writer (io/writer filepath)]
      (csv/write-csv writer
                     (cons (map name header) rows)))))