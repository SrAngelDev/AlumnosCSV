package srangeldev

import srangeldev.dto.AlumnoDto
import srangeldev.mapper.toModel
import java.io.File

fun main() {
    val file = File("data", "alumnos.csv")
    if (file.exists() && file.isFile && file.canRead()) {
        println("El fichero existe")
    } else {
        throw IllegalArgumentException("El fichero no existe o no se puede leer")
    }

    val alumnos = file.readLines().drop(1)
        .map { line -> line.split(",") }
        .map { item -> AlumnoDto(
            id = item[0].toInt(),
            nombre = item[1],
            createdAt = item[2],
            tipo = item[3],
            edad = item[4].toInt()
        ).toModel()
        }
    alumnos.forEach {println(it)}
    /*
    Alumno más mayor
    Alumno más joven
    Media de edad de alumnos
    Media de longitud de nombre
    Listado de agrupados por edad
    Agrupados por edad, numero de alumnos
    Agrupados por edad, obtener la longitud de nombre.
    Agrupados por edad, obtener el nombre mas largo.
*/
    println("Alumno mas mayor")
    alumnos.maxByOrNull { it.edad }?.let {println(it)}
    println()

    println("Alumno mas joven")
    alumnos.minByOrNull { it.edad }?.let {println(it)}
    println()

    println("Media de edad de alumnos")
    alumnos.map { it.edad }.average().let {println(it)}
    println()

    println("Media de longitud de nombre")
    alumnos.map { it.nombre.length }.average().let {println(it)}
    println()

    println("Listado de agrupados por edad")
    alumnos.groupBy { it.edad }.forEach{println(it)}
    println()

    println("Agrupados por edad, numero de alumnos")
    alumnos.groupingBy { it.edad }.eachCount().forEach {println(it)}
    println()

    println("Agrupados por edad, obtener la longitud de nombre.")
    alumnos.groupBy { it.edad }.mapValues { it.value.map { alumno -> alumno.nombre.length } }.forEach { println(it) }
    println()

    println("Agrupados por edad, obtener el nombre más largo.")
    alumnos.groupBy { it.edad }.mapValues { it.value.maxByOrNull { alumno -> alumno.nombre.length }?.nombre }.forEach { println(it) }
    println()

}