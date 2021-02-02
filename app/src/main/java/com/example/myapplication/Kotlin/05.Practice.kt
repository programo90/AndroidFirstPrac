package com.example.myapplication.Kotlin

fun plusThree(first: Int, second: Int, third: Int): Int {
    return first + second + third
}

fun minusThree(first: Int, second: Int, third: Int) = first - second - third

fun mutiplyThree(first: Int = 1, second: Int = 2, third: Int = 3): Int {
    return first * second * third
}

// 내부함수
fun showMyPlus(first: Int, second: Int): Int {
    println(first)
    println(second)

    fun plus(first: Int, second: Int):Int {
        return first + second
    }
    return plus(first, second)
}

fun main(array: Array<String>) {
    println(plusThree(1, 2, 3))
    println(minusThree(10, 5, 1))
    println(mutiplyThree(1, 2, 3))
    println(mutiplyThree())
}