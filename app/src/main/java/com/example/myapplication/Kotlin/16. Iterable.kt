package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    val mList = mutableListOf<Int>(1,2,3,4,5)

    for(item in mList) {
        if(item==5) {
            println(item)
        }
    }

    for((index, item) in mList.withIndex()) {
        println("" + index + " " + item)
    }

    mList.forEach {
        println(it)
    }

    mList.forEach { item ->
        println(item)
    }

    mList.forEachIndexed{ index, item ->
        println(""+index + " " + item)
    }

    var arr = arrayOf(1,2,3,4,5)

    //until은 마지막을 미포함
    for(i in 0 until arr.size) {
        println(arr[i])
    }

    //step() 에 지정해 준 수만큼 넘어간다.
    for(i in 0 until arr.size step(2)) {
        println(arr[i])
    }

    for(i in arr.size-1 downTo (0) step (2)) {
      println(arr[i])
    }

    //.. 은 마지막을 포함
    for (i in 0 .. 10) {
        println(i)
    }

    for((index, item) in arr.withIndex()) {

    }

    var a: Int = 0
    var b: Int = 4

    while(a<4) {

        break
    }

}
