# Kotlin初心者向け学習プラン（4週間）

## 環境構築手順

### 1. リポジトリの準備
```bash
# 新しいリポジトリを作成
mkdir kotlin-learning
cd kotlin-learning
git init
```

### 2. 設定ファイルの配置
- `.devcontainer/devcontainer.json` を作成
- `.devcontainer/setup.sh` を作成して実行権限を付与
```bash
chmod +x .devcontainer/setup.sh
```

### 3. GitHubにプッシュ
```bash
git add .
git commit -m "Initial setup"
git remote add origin https://github.com/YOUR_USERNAME/kotlin-learning.git
git push -u origin main
```

### 4. Codespacesで開く
- GitHubリポジトリページで「Code」→「Codespaces」→「Create codespace on main」

---

## 第1週：基礎文法

### Day 1-2：Hello World と基本構文
**学習内容:**
- 変数宣言（val/var）
- データ型（Int, String, Boolean, Double）
- 文字列テンプレート
- コメントの書き方

**実践課題:**
```kotlin
// src/main/kotlin/week1/Day01.kt
fun main() {
    val name = "太郎"
    var age = 25
    println("こんにちは、${name}さん！")
    println("${age}歳ですね。")
    
    age += 1
    println("来年は${age}歳です。")
}
```

### Day 3-4：制御構文
**学習内容:**
- if式
- when式
- forループ
- whileループ
- 範囲（Range）

**実践課題:**
```kotlin
// FizzBuzzゲームを作成
fun fizzBuzz(n: Int): String {
    return when {
        n % 15 == 0 -> "FizzBuzz"
        n % 3 == 0 -> "Fizz"
        n % 5 == 0 -> "Buzz"
        else -> n.toString()
    }
}

fun main() {
    for (i in 1..30) {
        println("$i: ${fizzBuzz(i)}")
    }
}
```

### Day 5-7：関数
**学習内容:**
- 関数の定義と呼び出し
- デフォルト引数
- 名前付き引数
- 単一式関数
- ラムダ式の基礎

**実践課題:**
```kotlin
// 簡単な電卓を作成
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    val add = { x: Int, y: Int -> x + y }
    val subtract = { x: Int, y: Int -> x - y }
    
    println("10 + 5 = ${calculate(10, 5, add)}")
    println("10 - 5 = ${calculate(10, 5, subtract)}")
}
```

---

## 第2週：オブジェクト指向

### Day 8-10：クラスとオブジェクト
**学習内容:**
- クラスの定義
- プロパティとメソッド
- コンストラクタ
- データクラス
- オブジェクト宣言

**実践課題:**
```kotlin
// 図書管理システムの基礎
data class Book(
    val title: String,
    val author: String,
    val year: Int,
    var isAvailable: Boolean = true
)

class Library {
    private val books = mutableListOf<Book>()
    
    fun addBook(book: Book) {
        books.add(book)
        println("「${book.title}」を追加しました")
    }
    
    fun listAvailableBooks() {
        println("\n利用可能な本:")
        books.filter { it.isAvailable }
            .forEach { println("- ${it.title} (${it.author})") }
    }
}
```

### Day 11-12：継承とインターフェース
**学習内容:**
- 継承（open、override）
- 抽象クラス
- インターフェース
- ポリモーフィズム

**実践課題:**
```kotlin
// 動物クラスの階層構造
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
```

### Day 13-14：高度なクラス機能
**学習内容:**
- Sealed クラス
- Enum クラス
- コンパニオンオブジェクト
- 拡張関数

**実践課題:**
```kotlin
// 状態管理システム
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

fun processResult(result: Result<String>) {
    when (result) {
        is Result.Success -> println("成功: ${result.data}")
        is Result.Error -> println("エラー: ${result.message}")
        is Result.Loading -> println("読み込み中...")
    }
}
```

---

## 第3週：コレクションと関数型プログラミング

### Day 15-17：コレクション操作
**学習内容:**
- List、Set、Map
- mutableとimmutable
- filter、map、reduce
- forEach、any、all、none

**実践課題:**
```kotlin
// 学生成績管理システム
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
    
    // 80点以上の生徒
    val topStudents = students.filter { it.score >= 80 }
    println("\n80点以上:")
    topStudents.forEach { println("${it.name}: ${it.score}点") }
    
    // 最高得点
    val topScore = students.maxByOrNull { it.score }
    println("\n最高得点: ${topScore?.name} (${topScore?.score}点)")
}
```

### Day 18-19：高階関数とスコープ関数
**学習内容:**
- 高階関数の作成
- let、apply、run、also、with
- シーケンス（Sequence）

**実践課題:**
```kotlin
// 設定ビルダーパターン
class Config {
    var host = "localhost"
    var port = 8080
    var timeout = 3000
    
    fun print() {
        println("Host: $host, Port: $port, Timeout: ${timeout}ms")
    }
}

fun buildConfig(builder: Config.() -> Unit): Config {
    return Config().apply(builder)
}

fun main() {
    val config = buildConfig {
        host = "example.com"
        port = 443
        timeout = 5000
    }
    config.print()
}
```

### Day 20-21：Null安全性
**学習内容:**
- Nullable型（?）
- 安全呼び出し（?.）
- エルビス演算子（?:）
- !!演算子
- let を使ったNull処理

**実践課題:**
```kotlin
// ユーザー検索システム
data class User(val id: Int, val name: String, val email: String?)

class UserRepository {
    private val users = listOf(
        User(1, "田中太郎", "tanaka@example.com"),
        User(2, "佐藤花子", null),
        User(3, "鈴木一郎", "suzuki@example.com")
    )
    
    fun findById(id: Int): User? = users.find { it.id == id }
    
    fun getUserEmail(id: Int): String {
        val user = findById(id)
        return user?.email ?: "メールアドレスが登録されていません"
    }
}
```

---

## 第4週：実践プロジェクト

### Day 22-24：TODO管理アプリ（CLI版）
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
            println("   ${task.description}")
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

### Day 25-26：テストの作成
**学習内容:**
- JUnit 5の基礎
- アサーション
- テストのベストプラクティス

**テスト例:**
```kotlin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TodoAppTest {
    @Test
    fun `タスクを追加できる`() {
        val app = TodoApp()
        app.addTask("買い物", "牛乳を買う")
        
        assertEquals(1, app.getTaskCount())
    }
    
    @Test
    fun `タスクを完了にできる`() {
        val app = TodoApp()
        app.addTask("掃除", "部屋を掃除する")
        app.toggleTask(1)
        
        assertTrue(app.getTask(1)?.isCompleted == true)
    }
}
```

### Day 27-28：リファクタリングと拡張
**目標:**
- コードの改善
- 新機能の追加（優先度、期限など）
- エラーハンドリングの改善

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

### Codespacesが起動しない
- ブラウザのキャッシュをクリア
- 別のブラウザで試す
- リポジトリの.devcontainerフォルダの配置を確認

### Kotlinがインストールされない
- setup.shの実行権限を確認
- ログを確認: `cat /tmp/setup.log`

### Gradleビルドが失敗する
```bash
./gradlew clean build --refresh-dependencies
```

頑張ってください！🚀