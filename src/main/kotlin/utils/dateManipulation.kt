package utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun secondsToDateTime(segundos: Long): String {
    val dataHora = LocalDateTime.ofEpochSecond(segundos, 0, java.time.ZoneOffset.UTC)
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    return dataHora.format(formatter)
}
