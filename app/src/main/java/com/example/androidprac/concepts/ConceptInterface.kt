package com.example.androidprac.concepts

class ConceptInterface {

}

interface Vehicle {

    fun fly(){

    }
    fun move(){

    }

}

class Car(var position: Int) : Vehicle {
    override fun move() {
        TODO("Not yet implemented")
    }

}

class Aeroplane(var position: Int) : Vehicle {
    override fun fly() {
        super.fly()

        position += 5
    }

}