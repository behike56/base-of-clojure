(ns base-of-clojure.vector-practice
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
  (get examine_vec index))

(defn examine_vec1-1
  "get: 連想コレクション、集合、文字列、配列、または ILookup 
        インスタンスにキーが存在しない場合は、not-found または nil を返します。"
  [index]
  (get examine_vec index "not-found"))

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

;;; 'change' a vector: assoc pop subvec replace

(defn change_assoc_vector1
  "assoc: assoc[iate]。マップに適用すると、同じ（ハッシュ化された/ソートされた）
   型の新しいマップを返します。vectorに適用すると、valをindexに含む新しいvectorを返します。
   注意 - indexは<=(count vector)でなければなりません。"
  [map key val]
  (assoc map key val))

(defn change_assoc_vector2
  "assoc: assoc[iate]。マップに適用すると、同じ（ハッシュ化された/ソートされた）
   型の新しいマップを返します。vectorに適用すると、valをindexに含む新しいvectorを返します。
   注意 - indexは<=(count vector)でなければなりません。"
  [map key kvs]
  (assoc map key kvs))

(defn change_pop_vector
  "pop: リストまたはキューの場合は、最初の項目を除いた新しいリスト/キューを返し、
   ベクトルの場合は、最後の項目を除いた新しいベクトルを返します。
   コレクションが空の場合は例外をスローします。
   注意 - next/butlastとは異なります。"
  [coll]
  (pop coll))

(defn change_subvec_vector1
  "subvec: vector 内の項目を start (包含) から end (排他) までの永続ベクトルで返します。
   end が指定されない場合、デフォルトは (count vector) です。この操作は O(1) であり、非常に高速です。
   なぜなら、結果のベクトルは元のベクトルと構造を共有し、トリミングが行われないからです。"
  [vec start]
  (subvec vec start))

(defn change_subvec_vector2
  "subvec: vector 内の項目を start (包含) から end (排他) までの永続ベクトルで返します。
   end が指定されない場合、デフォルトは (count vector) です。この操作は O(1) であり、非常に高速です。
   なぜなら、結果のベクトルは元のベクトルと構造を共有し、トリミングが行われないからです。"
  [vec start end]
  (subvec vec start end))

(defn change_replace_vector
  "replace: 置換ペアのマップとベクトル/コレクションが与えられた場合、
   任意の要素 = smapのキーがsmapの対応するvalで置換されたベクトル/seqを返します。
   コレクションが提供されない場合、変換器を返します。"
  [coll1 coll2]
  (replace coll1 coll2))
