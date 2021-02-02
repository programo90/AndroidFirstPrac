package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    val mList = mutableListOf<Int>()
    mList.add(1)
    mList.add(1, 2)

    val mSet = mutableSetOf<Int>()
    mSet.add(2)
    mSet.remove(2)
    //없는 값을 삭제하려 해도 상관없다.
    mSet.remove(3)

    val mMap = mutableMapOf<String, Int>("one" to 1)
    mMap.put("two", 2)
    mMap.replace("two",20)
    mMap.keys
    mMap.values
    mMap.clear()

}