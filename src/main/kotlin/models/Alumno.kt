package srangeldev.models

import java.time.LocalDate

data class Alumno(
    val id: Int,
    var nombre: String,
    var createdAt: LocalDate,
    var tipo: Tipo = Tipo.ALUMNO,
    var edad: Int
) {
    enum class Tipo{
        ALUMNO
    }
}
