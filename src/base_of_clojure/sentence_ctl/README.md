# 文字列操作

## 文字列結合

Clojureで文字列を結合する方法は主に以下の3つです：

1. **`clojure.string/join`** を使う：シーケンスの要素を区切り文字で連結します。
2. **`str`** を使う：引数として与えられたすべての値を連結します。
3. **`interpose` と `apply str`** を組み合わせて使う：区切り文字をシーケンスの間に挟んで連結します。

### `clojure.string/join` 関数

`clojure.string/join`関数は、シーケンスの要素を指定された区切り文字で連結します。区切り文字を指定しない場合、要素はそのまま連結されます。

#### 使用方法

```clojure
(require '[clojure.string :as str])

;; 区切り文字を指定しない場合
(str/join coll)

;; 区切り文字を指定する場合
(str/join separator coll)
```

#### 例

1. **区切り文字を指定せずに結合**

   ```clojure
   (require '[clojure.string :as str])

   (def words ["Hello" "World" "Clojure"])
   (def result (str/join words))

   (println result)  ;; => "HelloWorldClojure"
   ```

2. **区切り文字を指定して結合**

   ```clojure
   (require '[clojure.string :as str])

   (def words ["Hello" "World" "Clojure"])
   (def result (str/join " " words))

   (println result)  ;; => "Hello World Clojure"
   ```

### `str` 関数

`str`関数は、引数として与えられたすべての値を連結し、1つの文字列として返します。こちらもよく使われる方法です。

#### 使用方法

```clojure
(str & args)
```

#### 例

1. **複数の文字列を連結**

   ```clojure
   (def part1 "Hello")
   (def part2 "World")
   (def part3 "Clojure")
   (def result (str part1 " " part2 " " part3))

   (println result)  ;; => "Hello World Clojure"
   ```

2. **数値や他のデータ型も連結**

   ```clojure
   (def greeting "Hello")
   (def number 42)
   (def result (str greeting ", the answer is " number))

   (println result)  ;; => "Hello, the answer is 42"
   ```

### `interpose` 関数と `apply` 関数

`interpose`関数を使って区切り文字をシーケンスの間に挟み、その結果を`apply`と`str`を使って連結することもできます。

#### 使用方法

```clojure
(apply str (interpose separator coll))
```

#### 例

```clojure
(def words ["Hello" "World" "Clojure"])
(def result (apply str (interpose " " words)))

(println result)  ;; => "Hello World Clojure"
```

## フォーマット

フォーマット指定子の `d` は整数（10進数）を示しますが、他にも多くのフォーマット指定子が存在し、さまざまなデータ型やフォーマットのスタイルに対応しています。

### 一般的なフォーマット指定子

1. **整数のフォーマット**
   - `%d`: 10進数の整数
   - `%o`: 8進数の整数
   - `%x`: 16進数の整数（小文字）
   - `%X`: 16進数の整数（大文字）

2. **浮動小数点数のフォーマット**
   - `%f`: 固定小数点形式
   - `%e`: 指数形式（小文字）
   - `%E`: 指数形式（大文字）
   - `%g`: 指数形式または固定小数点形式のうち、より短い方を使用（小文字）
   - `%G`: 指数形式または固定小数点形式のうち、より短い方を使用（大文字）

3. **文字と文字列のフォーマット**
   - `%c`: 単一の文字
   - `%s`: 文字列

4. **その他のフォーマット**
   - `%b`: 真偽値（boolean）
   - `%h`: ハッシュコード（16進数）
   - `%n`: プラットフォームに依存する行区切り文字（改行）
   - `%%`: パーセント記号自体を出力

### 使用例

それぞれのフォーマット指定子の使用例をいくつか挙げます。

```clojure
;; 整数のフォーマット
(format "%d" 42)  ;; => "42"
(format "%o" 42)  ;; => "52"  (8進数)
(format "%x" 42)  ;; => "2a"  (16進数 小文字)
(format "%X" 42)  ;; => "2A"  (16進数 大文字)

;; 浮動小数点数のフォーマット
(format "%.2f" 3.14159)  ;; => "3.14"  (小数点以下2桁)
(format "%e" 3.14159)    ;; => "3.141590e+00"  (指数形式 小文字)
(format "%E" 3.14159)    ;; => "3.141590E+00"  (指数形式 大文字)

;; 文字と文字列のフォーマット
(format "%c" 65)         ;; => "A"  (文字)
(format "%s" "hello")    ;; => "hello"  (文字列)

;; その他のフォーマット
(format "%b" true)       ;; => "true"  (真偽値)
(format "%h" "hello")    ;; => "5e918d"  (ハッシュコード)
(format "%%")            ;; => "%"  (パーセント記号)
```
