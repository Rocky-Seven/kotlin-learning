// src/main/kotlin/com/learning/Day03Loops.kt
package com.learning

fun main() {
    println("=== Day 3: ループ処理 ===\n")

    // 課題1: forループ（範囲）
    println("1から5まで:")
    for (i in 1..5) {
        println("カウント: $i")
    }

    // 課題2: forループ（ステップ）
    println("\n2の倍数:")
    for (i in 2..10 step 2) {
        println(i)
    }

    // 課題3: whileループ
    println("\nカウントダウン:")
    var count = 5
    while (count > 0) {
        println("残り: $count")
        count--
    }
    println("発射！🚀")

    // 課題4: FizzBuzz
    println("\nFizzBuzz (1-20):")
    for (i in 1..20) {
        when {
            i % 15 == 0 -> println("$i: FizzBuzz")
            i % 3 == 0 -> println("$i: Fizz")
            i % 5 == 0 -> println("$i: Buzz")
            else -> println("$i: $i")
        }
    }
}
