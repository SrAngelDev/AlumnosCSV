package srangeldev.mapper

import srangeldev.dto.AlumnoDto
import srangeldev.models.Alumno
import java.time.LocalDate

fun Alumno.toDto() = AlumnoDto(
    id = id,
    nombre = nombre,
    createdAt = createdAt.toString(),
    tipo = tipo.toString(),
    edad = edad
)

fun AlumnoDto.toModel() = Alumno(
    id = id,
    nombre = nombre,
    createdAt = LocalDate.parse(createdAt),
    tipo = Alumno.Tipo.valueOf(tipo.uppercase()),
    edad = edad
)