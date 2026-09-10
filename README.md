# kotlin-learning

Kotlinの基礎文法を、GitHub Codespaces上で手を動かしながら学んでいくリポジトリである。学習の様子はブログ「[my-studies.org](https://my-studies.org)」の「Kotlin入門」シリーズとして記事化している。

A hands-on Kotlin learning repository built and documented alongside the "Kotlin入門" article series on my-studies.org. All code in this repository is written and tested inside GitHub Codespaces.

## 環境構築

Codespaceの作成からKotlin/Gradleのインストールまでは [SETUP.md](./SETUP.md) にまとめてある。初めてこのリポジトリを使う場合は、まずそちらを参照すること。

## プロジェクト構成

```
kotlin-learning/
├── .devcontainer/
│   └── devcontainer.json      # Codespaces環境定義（Java 21 + Kotlin拡張機能）
├── src/
│   ├── main/kotlin/com/learning/
│   │   ├── Day01Variables.kt
│   │   ├── Day02Conditionals.kt
│   │   ├── Day03Loops.kt
│   │   └── ...
│   └── test/kotlin/com/learning/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
├── README.md
└── SETUP.md
```

## 実行方法

各Dayのコードは`src/main/kotlin/com/learning/`フォルダにまとめて入っている。実行したいファイルを切り替えるには、`build.gradle.kts`の`mainClass`を変更する。

```kotlin
application {
    mainClass.set("com.learning.Day01VariablesKt") // 実行したいファイル名に変更
}
```

ファイル名の規則：

- `Day01Variables.kt` → `Day01VariablesKt`
- `Day02Conditionals.kt` → `Day02ConditionalsKt`
- `Main.kt` → `MainKt`

変更後、以下のコマンドで実行する。

```bash
./gradlew run
```

### トラブルシューティング

**`bash: ./gradlew: No such file or directory`**

プロジェクトのルートディレクトリ（このリポジトリのクローン先、Codespaceでは`/workspaces/kotlin-learning`）にいないことが原因である。

```bash
cd /workspaces/kotlin-learning
./gradlew run
```

`gradlew`自体が存在しない場合は、ルートディレクトリで以下を実行してwrapperを生成する。

```bash
gradle wrapper
```

※ `settings.gradle.kts`があるディレクトリ以外（サブフォルダなど）で実行すると、「Project directory ... is not part of the build」というエラーになるので、必ずリポジトリのルートで実行すること。

**`Could not find or load main class com.learning.XxxYyy`**

`mainClass`の指定で末尾の`Kt`を付け忘れている。`com.learning.Day03Loops`ではなく`com.learning.Day03LoopsKt`のように、必ずファイル名＋`Kt`にする。

**大量のログや警告が表示される**

`BUILD SUCCESSFUL`の文字と、プログラムの`println`による出力が表示されていれば実行は成功している。`[Incubating] Problems report`やDeprecated警告、`IDLE`表示などはGradle自体のメッセージであり、無視して問題ない。

## 学習内容（Kotlin入門シリーズ）

各回の詳しい解説はmy-studies.orgの記事を参照のこと。

| # | ファイル | 内容 |
|---|---|---|
| 01 | `Day01Variables.kt` | 変数（val/var）、基本的な型 |
| 02 | `Day02Conditionals.kt` | if文・if式、when式、Boolean演算子 |
| 03 | `Day03Loops.kt` | forループ（範囲・ステップ）、whileループ、FizzBuzz |
| 04 | `Day04Functions.kt`（予定） | 関数の定義・戻り値・デフォルト引数・単一式関数 |
| 05 | `Day05Collections.kt`（予定） | List・Set・Mapの基礎 |

## ライセンス

学習目的のリポジトリである。コードは自由に参照・流用して構わない。