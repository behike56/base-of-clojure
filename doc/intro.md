# Introduction to base-of-clojure

## やっていること

このプロジェクトでやっていることは、プログラミング言語のClojureの基本的な構文と関数の扱い方を１つづつ確かめていく。

## データ型

- nil
- Numbers
  - long
  - ratio
- Strings
- Characters
- Keywords
- Symbols
- Collections
- Lists (IPersistentList)
- Vectors (IPersistentVector)
- Maps (IPersistentMap)
- StructMaps
- ArrayMaps
- Sets

## Numbers

### 数値型に使用可能な関数

Computation: + - * / inc dec quot rem min max
Auto-promoting computation: +' -' *' inc' dec'
Comparison: == < <= > >= zero? pos? neg?
Bitwise operations: bit-and bit-or bit-xor bit-not bit-shift-right bit-shift-left
Ratios: numerator denominator
Coercions: int bigdec bigint double float long num short