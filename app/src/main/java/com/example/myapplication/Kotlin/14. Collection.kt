package com.example.myapplication.Kotlin

fun main(args: Array<String>) {

    //Immutable Collection
    val numList = listOf<Int>(1,2,3,3)

    val numSet = setOf<Int>(1,2,3,3,3)

    val numMap = mapOf<String,Int>("one" to 1, "two" to 2)

    //Mutable Collection
    val mNumList = mutableListOf<Int>(1,2,3)

    val mNumSet = mutableSetOf<Int>(1,2,3)

    val mNumMap = mutableMapOf<String, Int>("one" to 1, "two" to 2)

}