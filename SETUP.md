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
