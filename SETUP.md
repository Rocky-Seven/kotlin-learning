# GitHub Codespaces Kotlin環境セットアップ完全ガイド

このガイドに従えば、次回から迷わずKotlin学習環境を構築できます。

---

## 📋 事前準備

### 必要なもの
- GitHubアカウント
- Webブラウザ（Chrome、Edge、Firefox、Safari）

---

## 🚀 ステップ1: GitHubリポジトリの作成

### 1-1. GitHubで新しいリポジトリを作成

1. https://github.com/new にアクセス
2. 以下を入力：
   - **Repository name**: `kotlin-learning`（任意の名前でOK）
   - **Description**: `Kotlin学習用リポジトリ`
   - **Public** または **Private** を選択
   - **Add a README file** にチェック ✓
3. 「**Create repository**」をクリック

---

## 🛠️ ステップ2: 設定ファイルの準備

### 2-1. リポジトリをCodespacesで開く

1. 作成したリポジトリのページで「**Code**」ボタンをクリック
2. 「**Codespaces**」タブを選択
3. 「**Create codespace on main**」をクリック

→ Codespacesが起動します（1-2分かかります）

### 2-2. .devcontainerディレクトリとファイルを作成

ターミナルで以下のコマンドを**コピー&ペースト**して実行：

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

# .gitignoreを作成
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

# 確認
echo "✅ 設定ファイルの作成完了"
ls -la .devcontainer/
```

### 2-3. GitHubにコミット&プッシュ

```bash
# Gitの初期設定（初回のみ）
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# ファイルをコミット
git add .
git commit -m "Add devcontainer configuration and gitignore"
git push
```

---

## 🔧 ステップ3: Kotlinのインストール

### 3-1. Kotlinコンパイラをインストール

以下のコマンドを**まとめて**コピー&ペーストして実行：

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

**期待される出力:**
```
Kotlin version 2.0.20-release-360 (JRE 21.0.8+9-LTS)
```

### 3-2. Gradleの確認

Gradleは自動でインストールされているはずです。確認：

```bash
gradle -version
```

もし「command not found」と出たら：

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

## 📦 ステップ4: Kotlinプロジェクトの作成

### 4-1. プロジェクトディレクトリに移動

```bash
cd /workspaces/*
pwd  # 現在地を確認
```

### 4-2. プロジェクト構造を作成

以下をまとめてコピー&ペースト：

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

# 確認
echo "✅ プロジェクト作成完了"
ls -la
```

---

## ✅ ステップ5: 動作確認

### 5-1. プログラムを実行

```bash
./gradlew run
```

**期待される出力:**
```
> Task :run
🎉 Kotlin学習環境へようこそ！
Hello, Kotlin!
初心者 さん、Kotlinの学習を始めましょう！

BUILD SUCCESSFUL
```

### 5-2. 最終確認

```bash
# 全体チェック
echo "=== Kotlin ==="
kotlin -version

echo -e "\n=== Gradle ==="
gradle -version

echo -e "\n=== プロジェクト構造 ==="
tree src/ 2>/dev/null || find src/ -type f

echo -e "\n=== Git状態 ==="
git status
```

---

## 📝 ステップ6: Gitに保存

```bash
# すべての変更をコミット
git add .
git commit -m "Setup Kotlin learning environment"
git push

# 確認
git status
```

**期待される出力:**
```
On branch main
nothing to commit, working tree clean
```

---

## 🎓 完了！学習を開始

セットアップ完了です！以下のコマンドで学習を始められます：

```bash
# プログラムを実行
./gradlew run

# 新しいファイルを作成
# src/main/kotlin/com/learning/ 配下にファイルを追加

# ビルド
./gradlew build

# クリーン
./gradlew clean
```

---

## 🔄 次回以降のセットアップ（新しいCodespaceを作る場合）

1. GitHubリポジトリページを開く
2. 「Code」→「Codespaces」→「Create codespace on main」
3. Codespacesが起動したら、**ステップ3（Kotlinインストール）** のみ実行：

```bash
# Kotlinインストール（再実行）
cd /tmp
wget https://github.com/JetBrains/kotlin/releases/download/v2.0.20/kotlin-compiler-2.0.20.zip
unzip kotlin-compiler-2.0.20.zip
sudo mv kotlinc /usr/local/kotlinc
sudo ln -s /usr/local/kotlinc/bin/kotlin /usr/local/bin/kotlin
sudo ln -s /usr/local/kotlinc/bin/kotlinc /usr/local/bin/kotlinc

# プロジェクトディレクトリに移動
cd /workspaces/*

# 動作確認
./gradlew run
```

プロジェクトファイルは既にGitHubに保存されているので、再作成不要です！

---

## 🆘 トラブルシューティング

### Q1: Kotlinコンパイラのダウンロードが遅い
**A:** 別のミラーを使用：
```bash
cd /tmp
curl -LO https://github.com/JetBrains/kotlin/releases/download/v2.0.20/kotlin-compiler-2.0.20.zip
```

### Q2: gradle wrapperでエラーが出る
**A:** Gradleが見つからない場合、手動インストール（ステップ3-2参照）

### Q3: ./gradlew run で Permission denied
**A:** 実行権限を付与：
```bash
chmod +x gradlew
./gradlew run
```

### Q4: Git pushでエラーが出る
**A:** 認証が必要な場合：
```bash
# GitHubのPersonal Access Tokenを使用
# Settings → Developer settings → Personal access tokens
```

### Q5: Codespacesが途中で止まる
**A:** 
1. Ctrl+C で中断
2. ターミナルを再起動
3. 該当コマンドを再実行

---

## 📚 次のステップ

セットアップが完了したら、学習プランに従って進めましょう：

- **第1週**: 基礎文法（変数、制御構文、関数）
- **第2週**: オブジェクト指向
- **第3週**: コレクションと関数型プログラミング
- **第4週**: 実践プロジェクト

---

## 💡 便利なコマンド集

```bash
# プロジェクト構造を確認
tree -I 'build|.gradle' 2>/dev/null || ls -R src/

# ファイル検索
find src/ -name "*.kt"

# Kotlinファイルを直接実行（単一ファイル）
kotlinc YourFile.kt -include-runtime -d YourFile.jar
kotlin YourFile.jar

# Gradle タスク一覧
./gradlew tasks

# 依存関係の確認
./gradlew dependencies
```

---

## 🎉 おめでとうございます！

これでKotlin学習環境のセットアップは完璧です。このガイドを保存しておけば、次回から迷わずセットアップできます！

Happy Coding! 🚀