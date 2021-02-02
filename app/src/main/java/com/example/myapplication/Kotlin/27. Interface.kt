package com.example.myapplication.Kotlin

fun main(args: Array<String>) {

}

interface Person_inter {
    fun eat()
    fun sleep()
}

class Student_imple():Person_inter {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

}

open class Person() {
    open fun eat() {

    }

    open fun sleep() {

    }
}

class Student():Person() {

}

class Teacher():Person() {

}