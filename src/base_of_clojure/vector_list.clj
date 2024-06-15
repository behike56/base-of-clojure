(ns base-of-clojure.vector-list
  "ベクター型とリスト型の操作方法")

;;;; Vectors Related Functions
;;; Create a vector: vector vec vector-of
;;; Examine a vector: get nth peek rseq vector?
;;; 'change' a vector: assoc pop subvec replace
;;; See also zippers

;;; Create a vector

(defn make_vec
  "vector: 与えられた引からベクター型を作成する。"
  [vec]
  (vector 4 5 6 vec))

(defn make_vec2
  "vec: collectionからベクター型を作成する。"
  [coll]
  (vec coll))

(defn make_vec3
  "vector-of: 単一のプリミティブ型 t の新しいベクトルを作成する。"
  [keyword]
  (cond (= keyword :int) (vector-of :int 1 2 3 )
        (= keyword :long) (vector-of :long 1 2 3)
        (= keyword :float) (vector-of :float 1 2 3)
        (= keyword :double) (vector-of :double 1 2 3)
        (= keyword :byte) (vector-of :byte 1 2 3)
        (= keyword :short) (vector-of :short 1 2 3)
        (= keyword :boolean) (vector-of :boolean 1 2 3)
        :else (throw (IllegalArgumentException. (str "unsupported type: " keyword)))))

;;;  Examine a vector

(def examine_vec [2 4 6 8 10])

(defn examine_vec1
  "get: 連想コレクション、集合、文字列、配列、または ILookup 
        インスタンスにキーが存在しない場合は、not-found または nil を返します。"
  [index]
  (get index examine_vec))

(defn examine_vec1-1
  "get: 連想コレクション、集合、文字列、配列、または ILookup 
        インスタンスにキーが存在しない場合は、not-found または nil を返します。"
  [index]
  (get index examine_vec "not-found"))

(defn examine_vec2
  "nth: getはインデックスが範囲外の場合nilを返し、 nthはnot-foundが与えられない限り例外を投げる。 
        nthは文字列、Javaの配列、正規表現マッチャとリストに対しても動作し、 
        O(n)時間でシーケンスに対しても動作する。"
  [index]
  (nth examine_vec index))

(defn examine_vec3
  "peek: リストやキューの場合はfirstと同じで、ベクトルの場合はlastと同じだが、
         lastよりもはるかに効率的である。コレクションが空の場合はnilを返す。
         `coll`はコレクション"
  [coll]
  (peek coll))

(defn examine_vec4
  "rseq: rev（ベクトルでもソートマップでもよい）のアイテムを逆順に並べたものを定数時間で返す。
         revが空の場合はnilを返す。
         `rev`はリバース可能なコレクション, vectorやsorted-mapなど。"
  [rev]
  (rseq rev))

(defn examine_vec5
  "vector?: `x`が IPersistentVector を実装している場合は真を返す。"
  [x]
  (vector? x))

;;; 'change' a vector

;;;; Lists Related Functions
;;; Related functions
;;; Create a list: list list*
;;; Treat a list like a stack: peek pop
;;; Examine a list: list?

(defn make_list
  "range: 第1引数から、第2引数まで(`num`)の整数を順番に返す。"
  [num]
  (range 1 num))

(defn make_repeat_list
  "repeat: 引数に与えられた要素を繰り返したリストを返す。"
  [str]
  (repeat 4 str))

(defn make_repeatedly_list
  "repeatedly: 無限（与えられた場合は長さn）の遅延呼び出しシーケンスを返す。"
  [limit]
  (repeatedly limit #(rand-int 11)))

(defn make_replace_vector
  ""
  [map]
  ())