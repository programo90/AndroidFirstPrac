package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    val tv: TV = TV(listOf<String>("K","M","S"))
    tv.switch()
    println(tv.onOrOff)

    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())

}

class TV(val channels: List<String>) {
    var onOrOff :Boolean = false
    var currentChannelNumber = 0
        set(value) {
            if(value>=channels.size) {
                field = 0
            } else if(value<0) {
                field = channels.size -1
            } else
                field = value
        }
        get() {
            println()
            return field
        }

    fun switch() {
        onOrOff != onOrOff
    }

    fun checkCurrentChannel():String {
        return channels[currentChannelNumber]
    }

    fun channelUp() {
        currentChannelNumber++
    }

    fun channelDown() {
        currentChannelNumber --
    }
}