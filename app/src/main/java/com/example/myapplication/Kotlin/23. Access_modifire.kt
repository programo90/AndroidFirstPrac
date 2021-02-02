package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    val testAccess: TestAccess = TestAccess("아무개")

    testAccess.test()
    println(testAccess.name)

}

class Reward() {
    private val rewardAmount: Int = 1000
}

class TestAccess {
    var name: String = "홍길동"

    constructor(name: String) {
        this.name = name
    }

    fun test() {
        println("test 실행")
    }
}