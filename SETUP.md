# SETUP.md — Kotlin学習環境セットアップガイド

このガイドに従えば、GitHub Codespaces上にKotlinの学習環境を構築できる。初回セットアップと、Codespace削除後の再構築の両方に対応している。

---

## 事前準備

- GitHubアカウント
- Webブラウザ（Chrome、Edge、Firefox、Safariいずれか）

---

## ステップ1：リポジトリの作成

1. https://github.com/new にアクセスする
2. 以下を入力する
   - **Repository name**: `kotlin-learning`（任意の名前でよい）
   - **Description**: `Kotlin学習用リポジトリ`
   - Public または Private を選択する
   - **Add a README file** にチェックを入れる
3. 「**Create repository**」をクリックする

---

## ステップ2：Codespaceを起動し、設定ファイルを準備する

### 2-1. リポジトリをCodespacesで開く

1. リポジトリページで「**Code**」ボタンをクリックする
2. 「**Codespaces**」タブを選択する
3. 「**Create codespace on main**」をクリックする（起動まで1〜2分ほどかかる）

### 2-2. devcontainer.jsonと.gitignoreを作成する

ターミナルで以下をまとめてコピー&ペーストして実行する。

```bash
# .devcontainerディレクトリを作成
mkdir -p .devcontainer

# devcontainer.jsonを作成
cat > .devcontainer/devcontainer.json << 'EOF'
{
  "name": "Kotlin Learning Environment",
  "image": "mcr.microsoft.com/devcontainers/java:1-21-bullseye",

  "features": {
    "ghcr.io/devcontainers/features/java:1": {
      "version": "21",
      "installGradle": "true"
    }
  },

  "customizations": {
    "vscode": {
      "extensions": [
        "fwcd.kotlin",
        "vscjava.vscode-java-pack",
        "vscjava.vscode-gradle"
      ],
      "settings": {
        "kotlin.languageServer.enabled": true,
        "files.exclude": {
          "**/.gradle": true,
          "**/build": true
        }
      }
    }
  },

  "forwardPorts": [8080],
  "remoteUser": "vscode"
}
EOF

# .gitignoreを作成（ブラックリスト方式）
cat > .gitignore << 'EOF'
# Gradle
.gradle/
build/
!gradle/wrapper/gradle-wrapper.jar

# IntelliJ IDEA
.idea/
*.iml
*.iws
*.ipr
out/

# VS Code
.vscode/

# Codespaces
.codespaces/

# Kotlin
.kotlin/

# Temporary files
*.log
*.tmp
*.swp

# OS
.DS_Store
EOF

echo "✅ 設定ファイルの作成完了"
ls -la .devcontainer/
```

### 2-3. GitHubにコミット・プッシュする

```bash
# 初回のみ
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

git add .
git commit -m "devcontainerとgitignoreを追加"
git push
```

---

## ステップ3：Kotlinをインストールする

```bash
cd /tmp
wget https://github.com/JetBrains/kotlin/releases/download/v2.0.20/kotlin-compiler-2.0.20.zip
unzip kotlin-compiler-2.0.20.zip
sudo mv kotlinc /usr/local/kotlinc
sudo ln -s /usr/local/kotlinc/bin/kotlin /usr/local/bin/kotlin
sudo ln -s /usr/local/kotlinc/bin/kotlinc /usr/local/bin/kotlinc

# 確認
kotlin -version
```

以下のように表示されればインストール成功である。

```
Kotlin version 2.0.20-release-360 (JRE 21.0.8+9-LTS)
```

### Gradleの確認

devcontainerの機能で自動インストールされているはずだが、念のため確認する。

```bash
gradle -version
```

「command not found」と表示された場合のみ、以下で個別にインストールする。

```bash
cd /tmp
wget https://services.gradle.org/distributions/gradle-8.10.2-bin.zip
sudo apt-get update && sudo apt-get install -y unzip
unzip gradle-8.10.2-bin.zip
sudo mv gradle-8.10.2 /opt/gradle
sudo ln -s /opt/gradle/bin/gradle /usr/local/bin/gradle

# 確認
gradle -version
```

---

## ステップ4：Kotlinプロジェクトを作成する

```bash
cd /workspaces/*
pwd  # 現在地を確認
```

以下をまとめてコピー&ペーストして実行する。

```bash
# ディレクトリ構造を作成
mkdir -p src/main/kotlin/com/learning
mkdir -p src/test/kotlin/com/learning

# build.gradle.ktsを作成
cat > build.gradle.kts << 'EOF'
plugins {
    kotlin("jvm") version "2.0.20"
    application
}

group = "com.learning"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("com.learning.MainKt")
}
EOF

# settings.gradle.ktsを作成
cat > settings.gradle.kts << 'EOF'
rootProject.name = "kotlin-learning"
EOF

# 最初のKotlinファイルを作成
cat > src/main/kotlin/com/learning/Main.kt << 'EOF'
package com.learning

fun main() {
    println("🎉 Kotlin学習環境へようこそ！")
    println("Hello, Kotlin!")

    val name = "初心者"
    println("$name さん、Kotlinの学習を始めましょう！")
}
EOF

# Gradle Wrapperを生成
gradle wrapper

echo "✅ プロジェクト作成完了"
ls -la
```
## ステップ5：実行するファイルの切り替え

このプロジェクトでは複数の日のコードが同じ`src/main/kotlin/com/learning/`フォルダに入っている。実行したいファイルは`build.gradle.kts`の`mainClass`で指定する。

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

---

## ステップ6：Codespace再開時によくあるトラブル

Codespaceを再開したときや、しばらく間が空いてから作業を再開したときに起きやすい問題をまとめておく。

### 6-1. `bash: ./gradlew: No such file or directory`

プロジェクトのルートディレクトリ（Codespaceでは`/workspaces/kotlin-learning`）にいないことが原因である。

```bash
pwd   # 今いる場所を確認
cd /workspaces/kotlin-learning
./gradlew run
```

`ls`を実行して`settings.gradle.kts`が見えれば、正しい場所にいる。

### 6-2. ルートに移動しても`gradlew`自体が無い

その場合はプロジェクトのルートディレクトリで以下を実行し、wrapper一式（`gradlew`、`gradlew.bat`、`gradle`フォルダ）を生成する。

```bash
gradle wrapper
```

注意: `settings.gradle.kts`があるディレクトリ以外（例: `src/main/kotlin/com`のようなサブフォルダ）で実行すると、以下のようなエラーになる。

```
Project directory '...' is not part of the build defined by settings file '.../settings.gradle.kts'.
```

必ずリポジトリのルートディレクトリで実行すること。

### 6-3. `Could not find or load main class com.learning.XxxYyy`

`mainClass`の指定で末尾の`Kt`を付け忘れている。`com.learning.Day03Loops`ではなく`com.learning.Day03LoopsKt`のように、ファイル名にそのまま`Kt`を付ける必要がある。

### 6-4. 実行時に大量のログや警告が出る

`BUILD SUCCESSFUL`の文字と、プログラムの`println`による出力が確認できていれば実行は成功している。`[Incubating] Problems report`やDeprecated警告、待機中を示す`IDLE`表示などはGradle自体のメッセージであり、無視して問題ない。

---
---

## ステップ7：動作確認

```bash
./gradlew run
```

以下のように表示されれば成功である。

```
> Task :run
🎉 Kotlin学習環境へようこそ！
Hello, Kotlin!
初心者 さん、Kotlinの学習を始めましょう！

BUILD SUCCESSFUL
```

---

## ステップ8：Gitに保存する

```bash
git add .
git commit -m "Kotlin学習環境をセットアップ"
git push
git status
```

`nothing to commit, working tree clean` と表示されれば完了である。

---

## Codespaceの運用ルール（重要）

無料プランの場合、一定期間操作がないとCodespaceは自動的に停止する。さらにそのまま放置すると削除予告メールが届き、期限までに再開しなければ自動的に削除される。停止中のCodespaceも削除されるまではストレージを消費し続け、無料プランの月間ストレージ上限（15GB）を圧迫する。

そのため、**作業が一区切りついたら都度`git push`でコードをリポジトリに保存し、自分でCodespaceを削除しておく**のが基本の運用である。

---

## 次回以降のセットアップ（新しいCodespaceを作る場合）

プロジェクトファイルは既にGitHubに保存されているため、再作成は不要である。以下の手順のみでよい。

1. GitHubリポジトリページを開く
2. 「Code」→「Codespaces」→「Create codespace on main」
3. 起動したら、Kotlinのみ再インストールする

```bash
cd /tmp
wget https://github.com/JetBrains/kotlin/releases/download/v2.0.20/kotlin-compiler-2.0.20.zip
unzip kotlin-compiler-2.0.20.zip
sudo mv kotlinc /usr/local/kotlinc
sudo ln -s /usr/local/kotlinc/bin/kotlin /usr/local/bin/kotlin
sudo ln -s /usr/local/kotlinc/bin/kotlinc /usr/local/bin/kotlinc
```

4. プロジェクトディレクトリへ移動して動作確認する

```bash
cd /workspaces/*
./gradlew run
```

---

## トラブルシューティング（その他）

`./gradlew`関連のエラーは[ステップ5](#ステップ6 codespace再開時によくあるトラブル)を参照。
ここではそれ以外のよくある問題をまとめる。

**`./gradlew run`でPermission deniedと出る場合**

実行権限を付与する。

```bash
chmod +x gradlew
./gradlew run
```

**Kotlinコンパイラのダウンロードが遅い場合**

`wget`の代わりに`curl`を試す。

```bash
cd /tmp
curl -LO https://github.com/JetBrains/kotlin/releases/download/v2.0.20/kotlin-compiler-2.0.20.zip
```

**Git pushでエラーが出る場合**

認証が必要な場合はPersonal Access Tokenを使用する（Settings → Developer settings → Personal access tokens）。

---

## 便利なコマンド集

```bash
# プロジェクト構造を確認
find src/ -type f

# Kotlinファイルを検索
find src/ -name "*.kt"

# Kotlinファイルを直接実行（単一ファイル、Gradleを使わない場合）
kotlinc YourFile.kt -include-runtime -d YourFile.jar
kotlin YourFile.jar

# Gradleタスク一覧
./gradlew tasks

# 依存関係の確認
./gradlew dependencies

# クリーンビルド
./gradlew clean build
```