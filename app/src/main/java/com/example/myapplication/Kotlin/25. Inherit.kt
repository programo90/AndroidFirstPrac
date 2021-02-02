package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    var car3: Car3 = SuperCar3()
    println(car3.drive())
}

open class Car3() {
    open fun drive(): String {
        return "달린다."
    }

    fun stop() {

    }
}

class SuperCar3(): Car3() {
    override fun drive():String {
        return "빨리 " +super.drive()
    }
}

class Truck3() {

}

class Bus3() {

}