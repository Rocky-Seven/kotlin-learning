package com.learning

fun main() {
    println("=== Day 2: 条件分岐の基礎 ===\n")
    
    // 課題1: 基本的なif文
    val age = 20
    println("年齢: ${age}歳")
    
    if (age >= 18) {
        println("あなたは成人です")
    } else {
        println("あなたは未成年です")
    }
    
    // 課題2: if式（値を返す）
    val score = 75
    val result = if (score >= 60) "合格" else "不合格"
    println("\nスコア: ${score}点 → $result")
    
    // 課題3: when式（範囲による分岐）
    val grade = 85
    val evaluation = when {
        grade >= 90 -> "A: 優秀"
        grade >= 80 -> "B: 良好"
        grade >= 70 -> "C: 普通"
        grade >= 60 -> "D: もう少し"
        else -> "F: 再試験"
    }
    println("\n成績: ${grade}点 → $evaluation")
    
    // 課題4: when式（値による分岐）
    val dayOfWeek = 3
    val dayName = when (dayOfWeek) {
        1 -> "月曜日"
        2 -> "火曜日"
        3 -> "水曜日"
        4 -> "木曜日"
        5 -> "金曜日"
        6 -> "土曜日"
        7 -> "日曜日"
        else -> "不明"
    }
    println("\n今日は$dayName です")
    
    // 課題5: 複数条件の組み合わせ
    val temperature = 25
    val isRaining = false
    
    println("\n=== 今日の天気 ===")
    println("気温: ${temperature}℃")
    println("雨: ${if (isRaining) "降っている" else "降っていない"}")
    
    val recommendation = when {
        temperature >= 30 -> "暑いです！水分補給を忘れずに"
        temperature >= 20 && !isRaining -> "過ごしやすい天気です"
        temperature >= 20 && isRaining -> "傘を持って出かけましょう"
        temperature >= 10 -> "少し肌寒いです。上着があると良いでしょう"
        else -> "寒いです！暖かい服装で"
    }
    println("アドバイス: $recommendation")
    
    // チャレンジ課題: 自分の情報で判定してみよう
    println("\n=== チャレンジ課題 ===")
    val myScore = 0 // ← ここを変更してみよう（0-100）
    val myAge = 0   // ← ここを変更してみよう
    
    // ここにコードを書いてみよう！
    // ヒント1: myScoreを使って成績評価を表示
    // ヒント2: myAgeを使って年齢層を判定（子供/若者/中年/シニア など）
    
    println("\n学習のヒント:")
    println("1. myScore と myAge に値を入れてみましょう")
    println("2. if文 や when式 を使って判定を作ってみましょう")
    println("3. 複数の条件を組み合わせてみましょう")

    // エラー体験: when式のelse忘れ
val testScore = 50
val testResult = when {
    testScore >= 80 -> "優秀"
    testScore >= 60 -> "合格"
    // else を書かないとエラー！
    else -> "不合格" // これを追加
}
}