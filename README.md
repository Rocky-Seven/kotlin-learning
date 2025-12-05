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
│   ├── main/
│   │   └── kotlin/
│   │       └── com/
<<<<<<< HEAD
│   │           └── learning/ # 基本文法（学習中）
=======
│   │           └── learning/ # 基本文法(順次公開中)
>>>>>>> 3d58ae5 (Modified README.md)
│   ├── oop/              # オブジェクト指向（今後公開）
│   ├── collections/      # コレクション操作（今後公開）
│   ├── functions/        # 関数とラムダ（今後公開）
│   └── advanced/         # 応用トピック（今後公開）
├── exercises/            # 練習問題（今後公開）
<<<<<<< HEAD
└── README.md（このファイル）
=======
└── README.md(このファイル)
>>>>>>> 3d58ae5 (Modified README.md)
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

### Gradleプロジェクトの実行（推奨）

```bash
# ビルド
./gradlew build

# 実行
./gradlew run

# テスト
./gradlew test
```
学習用のコード実行には、単なるスクリプト実行（kotlinc -script）ではなく、Gradleを利用した ./gradlew run を推奨します。

./gradlew run

依存関係の自動管理、統一されたビルド環境（テスト、IDE連携）、実行環境の再現性が高いため、実際の開発に近い方法で学習できます。

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
