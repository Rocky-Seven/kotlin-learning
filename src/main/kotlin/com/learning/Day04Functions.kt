// src/main/kotlin/com/learning/Day04Functions.kt
package com.learning

// 課題1: 基本的な関数
fun greet(name: String) {
    println("こんにちは、${name}さん！")
}

// 課題2: 戻り値のある関数
fun add(a: Int, b: Int): Int {
    return a + b
}

// 課題3: 単一式関数
fun multiply(a: Int, b: Int) = a * b

// 課題4: デフォルト引数
fun introduce(name: String, age: Int = 20, city: String = "東京") {
    println("名前: $name, 年齢: ${age}歳, 出身: $city")
}

fun main() {
    println("=== Day 4: 関数の基礎 ===\n")

    // 関数の呼び出し
    greet("太郎")

    // 戻り値の利用
    val sum = add(10, 5)
    println("10 + 5 = $sum")

    val product = multiply(4, 3)
    println("4 × 3 = $product")

    // デフォルト引数
    introduce("花子")
    introduce("一郎", 25)
    introduce("次郎", 30, "大阪")
}