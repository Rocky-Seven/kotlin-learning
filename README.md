# kotlin-learning
Kotlinの学習用リポジトリです。GitHub Codespacesを使用して、ブラウザ上で即座にKotlin開発環境を構築できます。

## 🚀 はじめに

### GitHub Codespacesで開く

1. このリポジトリの **Code** ボタンをクリック
2. **Codespaces** タブを選択
3. **Create codespace on main** をクリック

数分でKotlin開発環境が自動的にセットアップされます。

## 📁 プロジェクト構成

```
kotlin-learning/
├── src/
│   ├── basics/          # 基本文法
│   ├── oop/             # オブジェクト指向
│   ├── collections/     # コレクション操作
│   ├── functions/       # 関数とラムダ
│   └── advanced/        # 応用トピック
├── exercises/           # 練習問題
└── README.md
```

## 🛠️ 環境

このCodespaceには以下が含まれています：

- Kotlin 1.9+
- Gradle
- OpenJDK 17
- VSCode拡張機能
  - Kotlin Language Support
  - Gradle for Java

## 💻 使い方

### Kotlinファイルの実行

```bash
# Kotlinスクリプトの実行
kotlinc -script src/basics/hello.kts

# Kotlinファイルのコンパイルと実行
kotlinc src/basics/Hello.kt -include-runtime -d hello.jar
java -jar hello.jar
```

### Gradleプロジェクトの実行

```bash
# ビルド
./gradlew build

# 実行
./gradlew run

# テスト
./gradlew test
```

## 📚 学習トピック

### 1. 基本文法
- 変数と定数（var, val）
- データ型
- 制御フロー（if, when, for, while）
- Null安全性

### 2. 関数
- 関数定義
- デフォルト引数
- 名前付き引数
- 拡張関数
- ラムダ式

### 3. オブジェクト指向
- クラスとオブジェクト
- 継承
- インターフェース
- データクラス
- Sealed Class

### 4. コレクション
- List, Set, Map
- コレクション操作関数（map, filter, reduce）
- Sequence

### 5. 応用
- コルーチン
- DSL
- ジェネリクス
- アノテーション

## 🎯 練習問題

`exercises/` ディレクトリに難易度別の練習問題があります：

- `easy/` - 初級
- `medium/` - 中級
- `hard/` - 上級

各問題にはテストファイルが含まれています。

## 📖 参考資料

- [Kotlin公式ドキュメント](https://kotlinlang.org/docs/home.html)
- [Kotlin Koans](https://play.kotlinlang.org/koans/overview)
- [Kotlin by Example](https://play.kotlinlang.org/byExample/overview)

## 🤝 コントリビューション

学習内容の追加や改善のPRを歓迎します！

## 📝 ライセンス

MIT License

---

Happy Learning! 🎉