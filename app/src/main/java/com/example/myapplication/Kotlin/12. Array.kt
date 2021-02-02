package com.example.myapplication.Kotlin

fun main(args: Array<String>) {

    var group1 = arrayOf<Int>(1,2,3,4,5)
    println(group1.get(0))
    println(group1[1])

    group1.set(0,0)
    println(group1[0])
    group1[0] = 1
    println(group1[0])
}