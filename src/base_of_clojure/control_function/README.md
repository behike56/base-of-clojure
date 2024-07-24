# 制御関数

Clojureには、条件分岐や繰り返し処理を行うためのさまざまな関数やマクロがあります。

## 条件分岐

1. **`if`**
   - 単純な条件分岐を行うために使用します。
   - 使用例:

     ```clojure
     (if true
       "true"
       "false")  ;; => "true"
     ```

2. **`if-let`**
   - 条件が真の場合にバインドも行います。
   - 使用例:

     ```clojure
     (if-let [x (some-fn)]
       (do-something x)
       (do-something-else))  ;; `x` が nil でない場合にバインド
     ```

3. **`if-not`**
   - 条件が偽の場合に実行するコードを指定します。
   - 使用例:

     ```clojure
     (if-not false
       "true"
       "false")  ;; => "true"
     ```

4. **`when`**
   - 条件が真の場合に複数の式を実行します。
   - 使用例:

     ```clojure
     (when true
       (println "This is true")
       (println "Still true"))  ;; 条件が真なら複数の式を実行
     ```

5. **`when-let`**
   - 条件が真の場合にバインドも行い、複数の式を実行します。
   - 使用例:

     ```clojure
     (when-let [x (some-fn)]
       (do-something x)
       (do-something-else))  ;; `x` が nil でない場合にバインド
     ```

6. **`cond`**
   - 複数の条件と対応するアクションを指定します。
   - 使用例:

     ```clojure
     (cond
       (< 1 2) "less"
       (> 1 2) "greater"
       :else "equal")  ;; => "less"
     ```

7. **`case`**
   - 値に基づく条件分岐を行います。等値比較のみ。
   - 使用例:

     ```clojure
     (case 2
       1 "one"
       2 "two"
       "default")  ;; => "two"
     ```

## 繰り返し処理

1. **`loop` と `recur`**
   - 明示的に再帰を行うために使用します。
   - 使用例:
     ```clojure
     (loop [i 0]
       (when (< i 5)
         (println i)
         (recur (inc i))))  ;; 0から4までを出力
     ```

2. **`for`**
   - リスト内包表記のように、シーケンスの各要素に対する処理を行います。
   - 使用例:

     ```clojure
     (for [x [1 2 3]
           y [4 5]]
       (* x y))  ;; => (4 5 8 10 12 15)
     ```

3. **`doseq`**
   - シーケンスの各要素に対して副作用を伴う処理を行います。
   - 使用例:

     ```clojure
     (doseq [x [1 2 3]
             y [4 5]]
       (println (* x y)))  ;; 各ペアに対して積を出力
     ```

4. **`dotimes`**
   - 指定回数繰り返し処理を行います。
   - 使用例:

     ```clojure
     (dotimes [i 5]
       (println i))  ;; 0から4までを出力
     ```

5. **`while`**
   - 条件が真である限り繰り返し処理を行います。
   - 使用例:

     ```clojure
     (def i (atom 0))
     (while (< @i 5)
       (println @i)
       (swap! i inc))  ;; 0から4までを出力
     ```
