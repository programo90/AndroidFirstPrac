package com.example.myapplication.Kotlin

fun main(args: Array<String>) {

}


interface Person_ {
    fun eat() {
        println("먹는다.")
    }
    fun sleep() {
        println("잔다")
    }

    abstract fun study()
}

class Student_: Person_{
    override fun study() {
        TODO("Not yet implemented")
    }

}

class Teacher_ : Person_ {
    override fun study() {
        TODO("Not yet implemented")
    }

}