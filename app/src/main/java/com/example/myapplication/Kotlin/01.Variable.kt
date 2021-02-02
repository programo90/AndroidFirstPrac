package com.example.myapplication.Kotlin

// Variable, Value
// var, val <val_name> = <value>
// var(Variable) - 모든 값이든 넣고 값 수정이 가능. 단, type은 처음에 넣은 값의 type으로 고정된다.
// val(Value) - 값을 넣으면 수정이 불가.

var num = 10
var hello = "hello"
var point = 3.4

val fix = 20

fun main(args:Array<String>) {

    num = 100;
    hello = "world"
    point = 3.14

    println(num)
    println(hello)
    println(point)

    println(fix)
}
