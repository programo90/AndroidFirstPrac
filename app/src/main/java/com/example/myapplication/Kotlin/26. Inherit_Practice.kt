package com.example.myapplication.Kotlin

fun main(args: Array<String>) {

    val monster:SuperMonster = SuperMonster(100,12)
    val night: SuperNight = SuperNight(120,8)
    monster.bite(night)

}

open class Character1(var hp:Int, var power:Int) {
    fun attack(character1: Character1, power: Int = this.power) {
        character1.defense(power)
    }

    open fun defense(damage:Int) {
        hp -= damage
        if(hp>0) {
            println("${javaClass.simpleName}의 남은체력은 $hp 입니다.")
        } else
            println("${javaClass.simpleName}이(가) 죽었습니다.")
    }

}

class SuperNight(hp:Int, power: Int): Character1(hp, power){

    val defensePower: Int = 2
    override fun defense(damage: Int) {
        super.defense(damage-defensePower)
    }
}


class SuperMonster(hp:Int, power:Int):Character1(hp,power) {
    fun bite(character1: Character1) {
        super.attack(character1,power+2)
    }

}