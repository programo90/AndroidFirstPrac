package com.example.myapplication.Kotlin


fun main(args : Array<String>) {

    var bigCar: Car = Car("v8 engine","big")
    var ucar: SuperCar = SuperCar("v12","strong","4")

    var runnableCar: RunnableCar = RunnableCar("simple engine", "short body")
    runnableCar.ride()
    runnableCar.navi("부산")
    runnableCar.drive()

    var runnableCar2 : RunnableCar2 = RunnableCar2("nice engine","long body")
    println(runnableCar2.body)
    println(runnableCar2.engine)

}

class Car(var engine:String, var body:String) {
}

class SuperCar {
    var engine: String
    var body : String
    var door : String
    constructor(engine: String, body: String, door:String) {
        this.engine = engine
        this.body = body
        this.door = door
    }

}

class Car1(var engine: String, var body : String) {
    var door: String=""

    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }
}

class Car2 {
    var engine: String = ""
    var body: String =""
    var door: String = ""

    constructor(engine: String, body: String) {
        this.engine = engine;
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunnableCar(engine: String, body: String) {
    fun ride() {
        println("탑승 하였습니다.")
    }

    fun drive() {
        println("달립니다.")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}

class RunnableCar2 {
    var engine: String
    var body: String

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    init {

    }

    fun ride() {
        println("탑승 하였습니다.")
    }

    fun drive() {
        println("달립니다.")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }

}

//오버로딩
class TestClass {
    fun test() {

    }

    fun test(t2: String) {

    }
}