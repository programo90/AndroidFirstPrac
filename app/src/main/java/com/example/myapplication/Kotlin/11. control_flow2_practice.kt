package com.example.myapplication.Kotlin

// 11. control_flow2_pracitce

fun main(args: Array<String>) {
    val value: Int? = null
    when (value) {
        null -> println("value is null")
        else -> println("values is not null")
    }

    val value2: Boolean? = null

    when (value2) {
        true -> println("value2 is true")
        false -> println("value2 is false")
        else -> println("value2 is null")
    }

    val value3 = when (value2) {
        true -> 1
        false -> 2
        else -> 3
    }
    println(value3)

    val value4: Int = 1
    when (value4) {
        is Int -> println("value4 is Int")
        else -> println("value4 is not Int")
    }

    val value5: Int = 10
    when(value5) {
        in 10 .. 20 -> println("value5 is in 10 - 20")
        else -> println("value5 is not in 10 - 20")
    }

}