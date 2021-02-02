package com.example.myapplication.Kotlin

//04. Function 함수
// fun <함수명> (변수명:type, 변수명:type, ... ) : 반환형 {
//     return 반환값
//  }

fun plus(first: Int, second: Int): Int {
    val result: Int = first + second
    return result
}

// 디폴트 값을 갖는 함수
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second
    return result
}

// return이 없는 함수, Unit은 생략도 가능하다.
fun plusPlus(first: Int, second: Int): Unit {
    val result: Int = first + second
    println(result)
}

// 축약형 function
fun plusShort(frist: Int, second: Int) = frist + second

// 가변인자를 갖는 함수
fun plusMany(vararg numbers:Int) {
    for(number in numbers) {
        println(number)
    }
}

fun main(array: Array<String>) {
    println(plus(1, 2))

    println(plusFive(10, 20))
    println(plusFive(10))

    plusPlus(20, 50)

    println(plusShort(100, 200))

    plusMany(1,2,3)
}