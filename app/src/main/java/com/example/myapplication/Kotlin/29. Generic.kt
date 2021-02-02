package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    val list1 = listOf(1,2,3,"a")
    val b: String = list1[1].toString()

    val list2 = listOf<String>("1","2","3","a")
    val c: String = list2[1]

    val list3 = listOf(1,2,3,4,"a","b","c",5.0)


}