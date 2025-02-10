package srangeldev.dto

import srangeldev.models.Alumno.Tipo
import java.time.LocalDateTime

data class AlumnoDto(
    val id: Int,
    var nombre: String,
    var createdAt: String,
    var tipo: String,
    var edad: Int
)