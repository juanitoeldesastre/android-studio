package com.juanitodev.myapplication

open class Animal {
    open fun sonido() {
        println("Este animal hace un sonido")
    }
}

class Perro : Animal() {
    override fun sonido() {
        println("El perro ladra")
    }
}

class Gato : Animal() {
    override fun sonido() {
        println("El gato maulla")
    }
}

fun hacerSonido(animal: Animal) {
    animal.sonido()
}

val miPerro: Animal = Perro()
val miGato: Animal = Gato()