# Kotlin学習リポジトリ

Kotlinの学習用リポジトリです。GitHub Codespacesを使用して、ブラウザ上で即座にKotlin開発環境を構築できます。

## セットアップ方法

1. このリポジトリの `Code` ボタンをクリック
2. `Codespaces` タブを選択
3. `Create codespace on main` をクリック

数分でKotlin開発環境が自動的にセットアップされます。

## プロジェクト構成

```
kotlin-learning/
├── src/
│   ├── main/
│   │   └── kotlin/
│   │       └── com/
│   │           └── learning/
│   │               ├── Main.kt          # 初期ファイル
│   │               ├── Day01Variables.kt # Day 1: 変数の基礎
│   │               ├── Day02Conditionals.kt # Day 2: 条件分岐
│   │               └── ...
│   └── test/
├── build.gradle.kts
└── README.md
```

## 開発環境

このCodespaceには以下が含まれています：

- Kotlin 1.9+
- Gradle
- OpenJDK 17
- VSCode拡張機能
  - Kotlin Language Support
  - Gradle for Java

## 基本的な使い方

### プログラムの実行方法

```bash
# ビルドと実行
./gradlew run

# ビルドのみ
./gradlew build

# テスト実行
./gradlew test
```

### 実行するファイルの変更方法

`build.gradle.kts` の `mainClass` を変更します：

```kotlin
application {
    mainClass.set("com.learning.Day01VariablesKt") // 実行したいファイル名に変更
}
```

ファイル名の規則：
- `Day01Variables.kt` → `Day01VariablesKt`
- `Day02Conditionals.kt` → `Day02ConditionalsKt`
- `Main.kt` → `MainKt`

## 学習の進捗

- [x] Day 00: 環境セットアップ
- [x] Day 01: 変数の基礎（val, var）
- [ ] Day 02: 条件分岐（if, when）
- [ ] Day 03: ループ処理（for, while）
- [ ] Day 04: 関数の基礎
- [ ] Day 05: コレクション入門
- [ ] Day 06: Null安全性
- [ ] Day 07: クラスとオブジェクト

## 学習トピック

### 基礎文法
- 変数と定数（var, val）
- データ型
- 制御フロー（if, when, for, while）
- Null安全性

### 関数
- 関数定義
- デフォルト引数
- 名前付き引数
- 拡張関数
- ラムダ式

### オブジェクト指向
- クラスとオブジェクト
- 継承
- インターフェース
- データクラス
- Sealed Class

### コレクション
- List, Set, Map
- コレクション操作関数（map, filter, reduce）
- Sequence

### 応用トピック
- コルーチン
- DSL
- ジェネリクス
- アノテーション

## 便利なコマンド

```bash
# 現在のディレクトリ確認
pwd

# ファイル一覧表示
ls -la src/main/kotlin/com/learning/

# Gitの状態確認
git status

# 変更を保存
git add .
git commit -m "Day02の練習完了"
git push
```

## コミットメッセージの例

わかりやすいメッセージをつけましょう：

- `git commit -m "Day01: 変数の基本を学習"`
- `git commit -m "Day02: 条件分岐を追加"`
- `git commit -m "Day03: ループ処理の練習"`
- `git commit -m "Day01の変数宣言を修正"`

## 練習問題

`exercises/` ディレクトリに難易度別の練習問題があります：

- `easy/` - 初級
- `medium/` - 中級
- `hard/` - 上級

各問題にはテストファイルが含まれています。

## コントリビューション

学習内容の追加や改善のPRを歓迎します！

## ライセンス

MIT License

---

Happy Learning! 🎉