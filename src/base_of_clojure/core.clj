(ns base-of-clojure.core
  (:require [base-of-clojure.filecontroller.file-reader :as fr]
            [base-of-clojure.filecontroller.file-writer :as fw]
            [clojure.java.io :as io]))  ;; io をインポート

(defn -main
  []
  (let [input-resource (io/resource "input/input.csv")  ;; resources/input/input.csv を指定
        output-file "resources/output/output.csv"  ;; 出力先を resources/output/output.csv にする場合
        csv-data (fr/read-csv input-resource)
        data-maps (fr/csv-to-maps csv-data)
        processed-data (fr/process-data data-maps)  ;; 処理関数を適用
        _ (fw/maps-to-csv processed-data output-file)]
    (println "CSVデータ:")
    (println csv-data)
    (println "マップ形式のデータ:")
    (println data-maps)
    (println "処理後のデータ:")
    (println processed-data))
  (println "CSVファイルの処理が完了しました。"))
