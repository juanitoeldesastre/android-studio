package com.juanitov.skibidi

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Bienvenido a la calculadora en Kotlin")
    println("Por favor, selecciona la operación que deseas realizar:")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")

    val operacion = scanner.nextInt()

    println("Ingresa el primer numero:")
    val num1 = scanner.nextDouble()

    println("Ingresa el segundo numero:")
    val num2 = scanner.nextDouble()

    val resultado = when (operacion) {
        1 -> num1 + num2
        2 -> num1 - num2
        3 -> num1 * num2
        4 -> {
            if (num2 != 0.0) {
                num1 / num2
            } else {
                println("Error: No se puede dividir por cero.")
                return
            }
        }
        else -> {
            println("Operacion no valida.")
            return
        }
    }

    println("El resultado es: $resultado")
}