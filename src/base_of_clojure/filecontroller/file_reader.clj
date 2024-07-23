(ns base-of-clojure.filecontroller.file-reader
  (:require [clojure.java.io :as io]))

(defn file_reader [filepath]
  (with-open [fin (io/reader filepath)]
    (doseq [str (line-seq fin)]
      (print str))))

