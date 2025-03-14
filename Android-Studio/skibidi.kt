package com.juanitov.skibidi

class ultraSkibidi {

    val constante: String = "Juanito"
    var contador: Int = 0
    var precio: Double = 3.99
    var esVerdadero: Boolean = true
    var nombre: String = "SENATI"

    val numeros = listOf(1, 2, 3, 4, 5)
    val nombres = mutableListOf("Ana", "Carlitos", "Selena")
    var tipoCambio: Double = 3.67

    fun calcularEnDolares(precio: Double, tipoCambio: Double): Double {
        return precio * tipoCambio
    }

    fun calcularEnSoles(precio: Double, tipoCambio: Double): Double {
        return precio / tipoCambio
    }
}

fun main() {
    val kotlin = ultraSkibidi()

    val respuesta = kotlin.calcularEnDolares(350.50, 3.67)

    println("el precio en soles es $respuesta")
}