# SORT

## big_sorting.bigSorting

**アルゴリズムの解説**

この問題では、非常に大きな整数を文字列として扱い、それらを数値の昇順でソートする必要があります。重要なポイントは、数値が最大で10^6桁もあるため、通常の整数型（例えば`int`や`long`）に変換するとオーバーフローしてしまうことです。そのため、数値を文字列のまま扱い、比較も文字列ベースで行う必要があります。

以下、アルゴリズムの詳細を解説します。

---

**1. ソート関数の使用**

```clojure
(sort comparator coll)
```

Clojureの`sort`関数を使用して、カスタムの比較関数`comparator`を用いてコレクション`coll`をソートします。

---

**2. 比較関数の定義**

```clojure
(fn [a b]
  (let [len-a (count a)
        len-b (count b)]
    (cond
      (< len-a len-b) -1
      (> len-a len-b) 1
      :else (compare a b))))
```

- **引数**: 2つの文字列`a`と`b`を受け取ります。
- **処理の流れ**:
  1. **桁数の比較**:
     - `len-a`と`len-b`にそれぞれ`a`と`b`の文字列の長さ（つまり桁数）を格納します。
     - **桁数が異なる場合**:
       - 桁数が少ない方が数値として小さいため、桁数を比較します。
       - `len-a`が`len-b`より小さい場合、`a`は`b`より小さいので`-1`を返します。
       - `len-a`が`len-b`より大きい場合、`a`は`b`より大きいので`1`を返します。
  2. **桁数が同じ場合**:
     - 文字列を辞書順で比較します。`compare`関数を使用しますが、桁数が同じ場合、文字列の辞書順比較は数値の大小関係と一致します。
     - `compare a b`は、`a`が`b`より小さい場合は負の値、等しい場合は`0`、大きい場合は正の値を返します。

---

**3. 全体のソート処理**

```clojure
(defn bigSorting [unsorted]
  (sort
    (fn [a b]
      ;; 上記の比較関数
    )
    unsorted))
```

- `unsorted`は、ソートされていない数値文字列のリストです。
- `sort`関数とカスタムの比較関数を用いて、`unsorted`をソートします。
- 結果として、数値の昇順にソートされた文字列のリストが得られます。

---

**4. アルゴリズムのポイント**

- **数値を文字列として扱う理由**:
  - 数値が非常に大きく、通常の数値型では扱えないため、文字列として扱います。
- **桁数の比較が重要な理由**:
  - 桁数が異なる場合、桁数の少ない方が確実に数値として小さいです。
  - 例えば、`"10"`（2桁）と`"2"`（1桁）では、`"2"`の方が小さい。
- **桁数が同じ場合の比較方法**:
  - 桁数が同じ場合、文字列の辞書順比較で数値の大小関係を正しく判定できます。
  - 例えば、`"123"`と`"124"`では、辞書順でも`"123"`が先になります。

---

**5. サンプル入力に対する動作**

サンプル入力:

```
6
31415926535897932384626433832795
1
3
10
3
5
```

**ソートの手順**:

1. **各数値の桁数を取得**:
   - `"1"` → 1桁
   - `"3"` → 1桁
   - `"3"` → 1桁
   - `"5"` → 1桁
   - `"10"` → 2桁
   - `"31415926535897932384626433832795"` → 32桁

2. **桁数で比較・ソート**:
   - 桁数が少ない順に並べます。
   - 1桁の数値が先頭に来ます。

3. **桁数が同じ数値の比較**:
   - 1桁の数値同士（`"1"`, `"3"`, `"3"`, `"5"`）は、文字列の辞書順で比較します。
   - 結果: `"1"`, `"3"`, `"3"`, `"5"`

4. **最終的なソート結果**:

```
1
3
3
5
10
31415926535897932384626433832795
```

---

**6. 注意点**

- **効率性**:
  - 入力の数が最大で`2 * 10^5`、各文字列の長さが最大`10^6`であるため、アルゴリズムの効率性が重要です。
  - 比較関数では、必要最低限の比較（桁数と場合によっては文字列全体の比較）しか行っていません。

- **Clojureの`sort`関数について**:
  - `sort`は安定ソートであり、同じ値の場合は元の順序を維持します。
  - カスタムの比較関数を適切に定義することで、望み通りのソートが可能です。

---

**7. まとめ**

- 非常に大きな数値を含む文字列のリストを、数値の昇順でソートするために、数値を文字列のまま比較します。
- 比較はまず桁数を基に行い、桁数が同じ場合は文字列の辞書順で比較します。
- Clojureの`sort`関数とカスタムの比較関数を使用して、効率的にソートを行います。

---

このアルゴリズムにより、巨大な数値を含む文字列のリストを正確かつ効率的にソートすることが可能になります。