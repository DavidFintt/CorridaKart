package utils

import java.time.LocalTime
import classes.pilot

val pilotMap = mutableListOf<pilot>()

fun pilotCreator(
    cod: String, hour: String, name: String, nLaps: String, timeRacing: String, velocity: String
) {
    try {
        val nLapsFormat = nLaps.toInt()
        val velocityFormat = velocity.replace(",", ".").toFloat()
        val hourFormat = LocalTime.parse(hour)
        val timeRacingFormat = LocalTime.parse("00:0$timeRacing")

        val pilotGet = pilot(
            hour = hourFormat,
            cod = cod,
            name = name,
            nLaps = nLapsFormat,
            timeRacing = timeRacingFormat,
            velocity = velocityFormat
        )
        pilotMap.add(pilotGet)
    } catch (ex: Exception) {
        println("Ocorreu um erro $ex")
    }
}
