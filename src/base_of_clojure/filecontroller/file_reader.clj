(ns base-of-clojure.filecontroller.file-reader
  (:require  [clojure.data.csv :as csv]
             [clojure.java.io :as io]))


(defn read-csv [filepath]
  (with-open [reader (io/reader filepath)]
    (doall
     (csv/read-csv reader))))

(defn csv-to-maps [csv-data]
  (let [header (map keyword (first csv-data))
        rows (rest csv-data)]
    (map (fn [row]
           (zipmap header row))
         rows)))

(defn process-data [data]
  (->> data
       (map #(update % :Age parse-long))
       (filter #(>= (:Age %) 30))))
