package com.juanitov.minterface

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Libros(
    val titulo: String,
    val autor: String,
    @SerializedName("ano_publicacion") val publicacion: Int,  // Mapeo del JSON a la variable correcta
    val genero: String,
    val disponibilidad: Boolean,
    val resumen: String,
    val calificaciones: List<Calificaciones> // Ahora es una lista
)

data class Calificaciones(
    val usuario: String,
    val puntuacion: Int,
    val comentario: String
)

fun main() {
    val datosJSON = """{
        "titulo": "Cien años de soledad",
        "autor": "Gabriel García Márquez",
        "ano_publicacion": 1967,
        "genero": "Realismo mágico",
        "disponibilidad": true,
        "resumen": "La novela narra la historia de la familia Buendía en el ficticio pueblo de Macondo, abordando temas como el amor, la soledad y el destino.",
        "calificaciones": [
            {
                "usuario": "Juan123",
                "puntuacion": 5,
                "comentario": "Una obra maestra de la literatura."
            },
            {
                "usuario": "Ana456",
                "puntuacion": 4,
                "comentario": "Una historia fascinante, aunque algo difícil de seguir en algunos momentos."
            }
        ]
    }""".trimIndent()

    // Convertir el JSON en un objeto de la Data Class
    val gson = Gson()
    val libro: Libros = gson.fromJson(datosJSON, Libros::class.java)

    // Imprimir los datos
    println("📚 Título: ${libro.titulo}")
    println("✍️ Autor: ${libro.autor}")
    println("📅 Año de publicación: ${libro.publicacion}")
    println("📖 Género: ${libro.genero}")
    println("📦 Disponible: ${if (libro.disponibilidad) "Sí" else "No"}")
    println("📜 Resumen: ${libro.resumen}")
    
    println("\n⭐ Calificaciones:")
    libro.calificaciones.forEach {
        println("- Usuario: ${it.usuario} | Puntuación: ${it.puntuacion}/5")
        println("  Comentario: ${it.comentario}")
    }
}
