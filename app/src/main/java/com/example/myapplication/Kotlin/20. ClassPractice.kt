package com.example.myapplication.Kotlin

fun main(args: Array<String>) {
    val account: Account = Account("홍길동","1990/1/1", 1000)
    println(account.checkBalance())
    println(account.withdraw(1000))
    println(account.withdraw(2000))

    val account2: Account2 = Account2("홍길동2" , "1990/1/2")
    println(account2.checkBalance())
}

class Account {
    val name: String
    val birth: String
    var balance: Int

    constructor(name:String, birth:String, balance: Int) {
        this.name = name
        this.birth = birth
        if(balance <=0) {
            this.balance = 0
        } else {
            this.balance = balance
        }
    }

    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int):Boolean {
        if(balance >= amount) {
            balance -= amount
            return true
        } else {
            return false
        }
    }

    fun save(amount : Int) {
        balance += amount
    }
}

class Account2(val name:String, val birth:String, var balance: Int = 1000) {
    fun checkBalance(): Int {
        return balance
    }

    fun withdraw(amount: Int):Boolean {
        return if(balance >= amount) {
            balance -= amount
            true
        } else {
            false
        }
    }

    fun save(amount : Int) {
        balance += amount
    }
}

class Account3(initialBalance: Int) {
    var balance: Int = if(initialBalance >=0) initialBalance else 0

    fun checkBalance(): Int {
        return balance
    }
}