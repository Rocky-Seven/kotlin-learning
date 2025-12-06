# Kotlin初心者向け学習プラン（4週間）

このSTUDYPLANは、GitHub Codespacesを使ったKotlin学習環境での体系的な学習プランです。

**関連ブログ記事:**
- [環境セットアップ編](https://my-studies.org/set-up-your-kotlin-learning-environment-with-github-codespaces/)
- [学習開始編（Day 1）](https://my-studies.org/start-learning-with-a-kotlin-learning-environment-set-up-with-github-codespaces/)

---

## 学習の進捗チェックリスト

- [ ] Day 00: 環境セットアップ
- [ ] Day 01: 変数の基礎（val, var）
- [ ] Day 02: 条件分岐（if, when）
- [ ] Day 03: ループ処理（for, while）
- [ ] Day 04: 関数の基礎
- [ ] Day 05: コレクション入門
- [ ] Day 06: Null安全性
- [ ] Day 07: クラスとオブジェクト

---

## 環境構築手順

### 1. リポジトリの準備

詳細な環境構築手順は [SETUP.md](./SETUP.md) を参照してください。

**簡易手順:**
```bash
# 1. GitHubでリポジトリを作成
# 2. Codespacesで開く
# 3. Kotlinをインストール
# 4. プロジェクト構造を作成
# 5. 動作確認
```

---

## 第1週：基礎文法

### Day 00: 環境セットアップ

**学習内容:**
- GitHub Codespacesの使い方
- Kotlinのインストール
- プロジェクトの作成と実行

**参考:** [SETUP.md](./SETUP.md)

---

### Day 01: 変数の基礎

**学習内容:**
- 変数宣言（val/var）
- データ型（Int, String, Boolean, Double）
- 文字列テンプレート
- コメントの書き方

**実践課題:**
```kotlin
// src/main/kotlin/com/learning/Day01Variables.kt
package com.learning

fun main() {
    println("=== Day 1: 変数の基礎 ===\n")
    
    // 課題1: val（変更不可）とvar（変更可能）
    val language = "Kotlin"
    var level = 1
    
    println("学習言語: $language")
    println("現在のレベル: $level")
    
    // 課題2: レベルアップ
    level = 2
    println("レベルアップ！ → $level")
    
    // 課題3: 自己紹介を作ってみよう
    val myName = "あなたの名前" // ← ここを変更
    val myAge = 25 // ← ここを変更
    val myHobby = "プログラミング" // ← ここを変更
    
    println("\n=== 自己紹介 ===")
    println("名前: $myName")
    println("年齢: ${myAge}歳")
    println("趣味: $myHobby")
}
```

**参考ブログ:** [Day 1 - 変数の基礎](https://my-studies.org/start-learning-with-a-kotlin-learning-environment-set-up-with-github-codespaces/)

---

### Day 02: 条件分岐

**学習内容:**
- if文とif式
- when式
- 複数条件の組み合わせ
- Boolean演算子（&&, ||, !）

**実践課題:**
```kotlin
// src/main/kotlin/com/learning/Day02Conditionals.kt
package com.learning

fun main() {
    println("=== Day 2: 条件分岐の基礎 ===\n")
    
    // 課題1: 基本的なif文
    val age = 20
    if (age >= 18) {
        println("あなたは成人です")
    } else {
        println("あなたは未成年です")
    }
    
    // 課題2: if式（値を返す）
    val score = 75
    val result = if (score >= 60) "合格" else "不合格"
    println("スコア: $score点 → $result")
    
    // 課題3: when式
    val grade = 85
    val evaluation = when {
        grade >= 90 -> "A: 優秀"
        grade >= 80 -> "B: 良好"
        grade >= 70 -> "C: 普通"
        grade >= 60 -> "D: もう少し"
        else -> "F: 再試験"
    }
    println("成績: $grade点 → $evaluation")
}
```

---

### Day 03: ループ処理

**学習内容:**
- forループ
- whileループ
- 範囲（Range）
- repeat関数
- break/continue

**実践課題:**
```kotlin
// src/main/kotlin/com/learning/Day03Loops.kt
package com.learning

fun main() {
    println("=== Day 3: ループ処理 ===\n")
    
    // 課題1: forループ（範囲）
    println("1から5まで:")
    for (i in 1..5) {
        println("カウント: $i")
    }
    
    // 課題2: forループ（ステップ）
    println("\n2の倍数:")
    for (i in 2..10 step 2) {
        println(i)
    }
    
    // 課題3: whileループ
    println("\nカウントダウン:")
    var count = 5
    while (count > 0) {
        println("残り: $count")
        count--
    }
    println("発射！🚀")
    
    // 課題4: FizzBuzz
    println("\nFizzBuzz (1-20):")
    for (i in 1..20) {
        when {
            i % 15 == 0 -> println("$i: FizzBuzz")
            i % 3 == 0 -> println("$i: Fizz")
            i % 5 == 0 -> println("$i: Buzz")
            else -> println("$i: $i")
        }
    }
}
```

---

### Day 04: 関数の基礎

**学習内容:**
- 関数の定義と呼び出し
- パラメータと戻り値
- デフォルト引数
- 名前付き引数
- 単一式関数

**実践課題:**
```kotlin
// src/main/kotlin/com/learning/Day04Functions.kt
package com.learning

// 課題1: 基本的な関数
fun greet(name: String) {
    println("こんにちは、${name}さん！")
}

// 課題2: 戻り値のある関数
fun add(a: Int, b: Int): Int {
    return a + b
}

// 課題3: 単一式関数
fun multiply(a: Int, b: Int) = a * b

// 課題4: デフォルト引数
fun introduce(name: String, age: Int = 20, city: String = "東京") {
    println("名前: $name, 年齢: $age歳, 出身: $city")
}

fun main() {
    println("=== Day 4: 関数の基礎 ===\n")
    
    // 関数の呼び出し
    greet("太郎")
    
    // 戻り値の利用
    val sum = add(10, 5)
    println("10 + 5 = $sum")
    
    val product = multiply(4, 3)
    println("4 × 3 = $product")
    
    // デフォルト引数
    introduce("花子")
    introduce("一郎", 25)
    introduce("次郎", 30, "大阪")
}
```

---

### Day 05: コレクション入門

**学習内容:**
- List（リスト）
- Set（セット）
- Map（マップ）
- mutableとimmutable
- 基本的なコレクション操作

**実践課題:**
```kotlin
// src/main/kotlin/com/learning/Day05Collections.kt
package com.learning

fun main() {
    println("=== Day 5: コレクション入門 ===\n")
    
    // 課題1: List
    val fruits = listOf("りんご", "バナナ", "オレンジ")
    println("果物: $fruits")
    println("最初の果物: ${fruits[0]}")
    println("果物の数: ${fruits.size}")
    
    // 課題2: Mutable List
    val tasks = mutableListOf("買い物", "掃除")
    tasks.add("洗濯")
    println("\nタスク: $tasks")
    
    // 課題3: Set（重複なし）
    val numbers = setOf(1, 2, 3, 2, 1)
    println("\n数字セット: $numbers") // [1, 2, 3]
    
    // 課題4: Map（キーと値）
    val scores = mapOf(
        "田中" to 85,
        "佐藤" to 92,
        "鈴木" to 78
    )
    println("\n成績:")
    for ((name, score) in scores) {
        println("$name: $score点")
    }
}
```

---

### Day 06: Null安全性

**学習内容:**
- Nullable型（?）
- 安全呼び出し（?.）
- エルビス演算子（?:）
- !!演算子
- let を使ったNull処理

**実践課題:**
```kotlin
// src/main/kotlin/com/learning/Day06NullSafety.kt
package com.learning

fun main() {
    println("=== Day 6: Null安全性 ===\n")
    
    // 課題1: Nullable型
    var name: String? = "太郎"
    name = null // OK
    
    // 課題2: 安全呼び出し
    val length = name?.length
    println("名前の長さ: $length") // null
    
    // 課題3: エルビス演算子
    val displayName = name ?: "名無し"
    println("表示名: $displayName")
    
    // 課題4: letを使った処理
    val email: String? = "test@example.com"
    email?.let {
        println("メール送信: $it")
    }
    
    // 課題5: 実践例
    val users = mapOf(
        1 to "田中",
        2 to null,
        3 to "佐藤"
    )
    
    for ((id, userName) in users) {
        val display = userName ?: "未登録"
        println("ID: $id, 名前: $display")
    }
}
```

---

### Day 07: クラスとオブジェクト

**学習内容:**
- クラスの定義
- プロパティとメソッド
- コンストラクタ
- データクラス
- オブジェクト宣言

**実践課題:**
```kotlin
// src/main/kotlin/com/learning/Day07Classes.kt
package com.learning

// 課題1: 基本的なクラス
class Person(val name: String, var age: Int) {
    fun introduce() {
        println("私は${name}です。${age}歳です。")
    }
    
    fun birthday() {
        age++
        println("誕生日おめでとう！${age}歳になりました。")
    }
}

// 課題2: データクラス
data class Book(
    val title: String,
    val author: String,
    val year: Int
)

// 課題3: オブジェクト宣言（シングルトン）
object Counter {
    private var count = 0
    
    fun increment() {
        count++
    }
    
    fun getCount() = count
}

fun main() {
    println("=== Day 7: クラスとオブジェクト ===\n")
    
    // クラスの使用
    val person = Person("太郎", 25)
    person.introduce()
    person.birthday()
    
    // データクラスの使用
    val book = Book("Kotlinプログラミング", "山田太郎", 2024)
    println("\n本の情報: $book")
    
    // オブジェクトの使用
    Counter.increment()
    Counter.increment()
    println("\nカウント: ${Counter.getCount()}")
}
```

---

## 第2週：オブジェクト指向とコレクション操作

### Day 08-10: 継承とインターフェース

**学習内容:**
- 継承（open、override）
- 抽象クラス
- インターフェース
- ポリモーフィズム

**実践課題:**
```kotlin
abstract class Animal(val name: String) {
    abstract fun makeSound(): String
    
    fun introduce() {
        println("私は${name}です。${makeSound()}")
    }
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() = "ワンワン！"
}

class Cat(name: String) : Animal(name) {
    override fun makeSound() = "ニャー！"
}

fun main() {
    val animals = listOf(
        Dog("ポチ"),
        Cat("タマ")
    )
    
    animals.forEach { it.introduce() }
}
```

---

### Day 11-14: コレクション操作関数

**学習内容:**
- filter、map、reduce
- forEach、any、all、none
- sorted、groupBy
- flatMap、zip

**実践課題:**
```kotlin
data class Student(val name: String, val score: Int)

fun main() {
    val students = listOf(
        Student("田中", 85),
        Student("佐藤", 92),
        Student("鈴木", 78),
        Student("高橋", 88)
    )
    
    // 平均点
    val average = students.map { it.score }.average()
    println("平均点: ${"%.1f".format(average)}")
    
    // 80点以上
    val topStudents = students.filter { it.score >= 80 }
    println("\n80点以上:")
    topStudents.forEach { println("${it.name}: ${it.score}点") }
    
    // 最高得点
    val topScore = students.maxByOrNull { it.score }
    println("\n最高得点: ${topScore?.name} (${topScore?.score}点)")
}
```

---

## 第3週：高度な機能

### Day 15-17: ラムダ式と高階関数

**学習内容:**
- ラムダ式の基礎
- 高階関数の作成
- スコープ関数（let、apply、run、also、with）

---

### Day 18-21: 実践的なパターン

**学習内容:**
- Sealed クラス
- Enum クラス
- 拡張関数
- DSL（Domain Specific Language）

---

## 第4週：実践プロジェクト

### Day 22-28: TODO管理アプリ（CLI版）

**目標:** これまで学んだ内容を統合した実用的なアプリを作成

**実装機能:**
- タスクの追加
- タスクの一覧表示
- タスクの完了/未完了切替
- タスクの削除
- データの保存（ファイルI/O）

**コア実装例:**
```kotlin
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    var isCompleted: Boolean = false
)

class TodoApp {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1
    
    fun addTask(title: String, description: String) {
        tasks.add(Task(nextId++, title, description))
        println("✅ タスクを追加しました")
    }
    
    fun listTasks() {
        if (tasks.isEmpty()) {
            println("タスクはありません")
            return
        }
        
        println("\n📋 タスク一覧:")
        tasks.forEach { task ->
            val status = if (task.isCompleted) "✓" else "○"
            println("[$status] ${task.id}. ${task.title}")
        }
    }
    
    fun toggleTask(id: Int) {
        tasks.find { it.id == id }?.let { task ->
            task.isCompleted = !task.isCompleted
            val status = if (task.isCompleted) "完了" else "未完了"
            println("タスクを${status}にしました")
        } ?: println("❌ タスクが見つかりません")
    }
}

fun main() {
    val app = TodoApp()
    
    while (true) {
        println("\n=== TODOアプリ ===")
        println("1. タスク追加")
        println("2. タスク一覧")
        println("3. タスク完了/未完了")
        println("4. 終了")
        print("選択: ")
        
        when (readLine()) {
            "1" -> {
                print("タイトル: ")
                val title = readLine() ?: ""
                print("説明: ")
                val desc = readLine() ?: ""
                app.addTask(title, desc)
            }
            "2" -> app.listTasks()
            "3" -> {
                print("タスクID: ")
                val id = readLine()?.toIntOrNull() ?: 0
                app.toggleTask(id)
            }
            "4" -> {
                println("👋 終了します")
                return
            }
        }
    }
}
```

---

## 学習のコツ

### 毎日の学習習慣
- **30分～1時間**のコーディング時間を確保
- 学んだことを**必ず手を動かして実践**
- エラーを恐れず、**試行錯誤を楽しむ**

### 効果的な学習方法
1. **まずコードを書く** - 理論より実践
2. **エラーメッセージを読む** - デバッグスキルの向上
3. **コードを読む** - Kotlin標準ライブラリのソースを見る
4. **小さく改善** - 動くコードを少しずつ改善

### 推奨リソース
- 公式ドキュメント: https://kotlinlang.org/docs/home.html
- Kotlin Koans（練習問題）: https://play.kotlinlang.org/koans
- GitHub上のKotlinプロジェクト

### 次のステップ
4週間完了後は以下に挑戦:
- **Ktor**（Webフレームワーク）でAPIサーバー構築
- **Android開発**の基礎
- **Kotlin Coroutines**（非同期処理）
- **Spring Boot** + Kotlinでバックエンド開発

---

## トラブルシューティング

詳細なトラブルシューティングは [SETUP.md](./SETUP.md) を参照してください。

### よくある問題

**Codespacesが起動しない:**
- ブラウザのキャッシュをクリア
- 別のブラウザで試す

**Kotlinがインストールされない:**
- SETUP.mdの手順を再実行
- 実行権限を確認

**Gradleビルドが失敗する:**
```bash
./gradlew clean build --refresh-dependencies
```

---

頑張ってください！🚀