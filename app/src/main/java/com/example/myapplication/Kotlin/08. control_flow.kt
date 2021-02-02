package com.example.myapplication.Kotlin

// 08.

fun main(array: Array<String>) {
    //if, else
    //if, else if, else
    var a = 1
    var b = 2

    if (a > b) {
        println("a > b")
    } else {
        println("a <= b")
    }

    if (a > b) {
        println("a > b")
    } else if (a < b) {
        println("a < b")
    } else {
        println("a == b")
    }

    //값을 리턴하는 if
    var max = if(a>b) {
        a
    } else if(a<b){
        b
    } else {
        0
    }

}