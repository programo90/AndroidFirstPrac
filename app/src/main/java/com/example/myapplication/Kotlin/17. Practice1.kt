package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    var intList1 = mutableListOf<Int>()
    var boolList1 = MutableList(10,{false})

    val tempList = List(10, {0})

    for(i in 0 until 10) {
        intList1.add(i);
    }

    intList1.forEachIndexed { i, item ->
        boolList1[i] = item%2 == 0
    }


    for(i in 0 until intList1.size) {
        if(intList1.get(i)%2 == 0) {
            boolList1.add(i, true)
        } else {
            boolList1.add(i,false)
        }
    }

    var score = 79
    var rank = when(score) {
        in 80 .. 90 -> "A"
        in 70 .. 79 -> "B"
        in 60 .. 69 -> "C"
        else -> "F"
    }

    println(rank)

    var num1 = 15
    var num2 = num1/10 + num1%10

    println(num2)

    for(i in 1 .. 9) {
        for(j in 1 .. 9) {
            println(""+i+" x " + j + " = " + (i*j))
            println("$i x $j = ${i*j}")
        }
    }

}