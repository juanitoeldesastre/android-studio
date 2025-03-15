package com.juanitov.skibidi

class UltraSkibidi {
    val constante: String = "Juanito"
    var contador: Int = 0
    var precio: Double = 3.99
    var esVerdadero: Boolean = true
    var nombre: String = "SENATI"

    val numeros = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val nombres = mutableListOf("Ana", "Carlitos", "Selena")
    var tipoCambio: Double = 3.67
    var edad: Int = 0

    fun convertirADolares(precio: Double, tipoCambio: Double): Double = precio / tipoCambio

    fun convertirASoles(precio: Double, tipoCambio: Double): Double = precio * tipoCambio

    fun esMayorDeEdad(edad: Int): Boolean = edad >= 18

    fun mostrarNumeros() {
        for (i in 1..20) {
            if (i % 2 == 0) {
                println(i)
            }
        }
    }

    fun recorrerLista() {
        numeros.forEach { println(it) }
    }

    fun ordenarLista() {
        val ordenadosDescendente = numeros.sortedDescending()
        println("Lista ordenada descendente: $ordenadosDescendente")
    }

    fun filtrarLista() {
        val mayoresA7 = numeros.filter { it > 7 }
        println("Los numeros mayores a 7 son : $mayoresA7")
    }

    fun multiplicarPor2() {
        val duplicar = numeros.map { it * 2 }
        println("Los numeros multiplicados por dos son $duplicar")
    }

    fun mostrarImpares() {
        for (i in 1..10) {
            if (i % 2 != 0)
                println(i)
        }
    }

    fun filtrarListaImparPor3() {
        val impares = numeros.filter { it % 2 != 0 }
        val cuadrados = impares.map { it * it }
        println("El filtrado final es $cuadrados")
    }

    fun mostrarMinMax() {
        if (numeros.isNotEmpty()) {
            val min = numeros.minOrNull()
            val max = numeros.maxOrNull()
            println("El n minimo en la lista es: $min")
            println("El n maximo en la lista es: $max")
        } else {
            println("La lista está vacía.")
        }
    }
}

fun main() {
    val kotlin = UltraSkibidi()
    val precioEnDolares = kotlin.convertirADolares(350.50, 3.67)
    println("El precio en dolares es $precioEnDolares")

    val respuesta = kotlin.esMayorDeEdad(5)
    if (respuesta) {
        println("Tu mama es mayor de edad")
    } else {
        println("Tu mama es menor de edad")
    }

    kotlin.filtrarListaImparPor3()
    kotlin.mostrarMinMax()
}
