package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    var cal1: Cal1 = Cal1()
    cal1.add(1,2)
    cal1.min(1,2)

    var cal3:Cal3 = Cal3(3)
    cal3.plus(5).plus(5)

}

class Cal1 {
    fun add(a:Int, b:Int):Int {
        return a+b
    }

    fun min(a:Int, b:Int):Int{
        return a-b
    }

    fun mul(a:Int, b:Int):Int{
        return a*b
    }

    fun div(a:Int, b:Int):Int {
        return a/b
    }

}

class Cal2() {
    fun add(vararg numbers: Int):Int {
        var result = 0;
        numbers.forEach {
            result += it
        }
        return result
    }

    fun min(vararg numbers: Int):Int {
        var result = 0
        for(i in 0 until numbers.size) {
            result -= numbers[i]
        }
        return result
    }

    fun mul(vararg numbers: Int):Int {
        var result:Int = 1
        numbers.forEach {
            result *= it
        }
        return result
    }

    fun div(vararg numbers:Int): Int {
       var result: Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            if(index != 0) {
                if(value!=0) {
                    result /= value
                }
            }
        }
        return result
    }
}

class Cal3(var initialValue: Int) {
    fun plus(number: Int): Cal3 {
        var result = this.initialValue + number
        return Cal3(result)
    }

    fun min(number: Int): Cal3 {
        var result = this.initialValue - number
        return Cal3(result)
    }

    fun mul(number: Int):Cal3 {
        var result = this.initialValue* number
        return Cal3(result)
    }

    fun div(number: Int):Cal3 {
        var result = this.initialValue / number
        return Cal3(result)
    }
}