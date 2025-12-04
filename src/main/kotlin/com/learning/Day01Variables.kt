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
    val myName = "田中太郎"  // ← ここを変更
    val myAge = 35              // ← ここを変更
    val myHobby = "映画鑑賞" // ← ここを変更
    
    println("\n=== 自己紹介 ===")
    println("名前: $myName")
    println("年齢: ${myAge}歳")
    println("趣味: $myHobby")
}
