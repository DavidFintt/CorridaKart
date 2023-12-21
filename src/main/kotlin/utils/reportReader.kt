package utils

import java.io.File
import classes.pilot

fun reportReader() {
    val archiveDirectory = "src/main/resources/report.txt/"
    val listInfo = ArrayList<Any?>()

    fun indexPosition(prop: String) = when (prop) {
        "aroundi" -> 5
        "aroundf" -> 6
        "timeRacei" -> 7
        "timeRacef" -> 15
        "velocityAvi" -> 16
        else -> 0
    }

    try {
        val archive = File(archiveDirectory)

        archive.bufferedReader().useLines { lines ->
            lines.forEach { line ->
                val pilotCod = line.substring(13, 16)
                val pilotNameSplit = line.replace(Regex("[^a-zA-Z]"), "")
                val pilotName = "${pilotNameSplit[0]}.${pilotNameSplit.drop(1)}"
                val pilotHour = line.substring(0, 12)

                val startIndexAround = pilotHour.length + pilotCod.length + pilotName.length
                val finalIndexAround = pilotHour.length + pilotCod.length + pilotName.length

                val pilotLaps = line.substring(
                    startIndexAround + indexPosition("aroundi"), finalIndexAround + indexPosition("aroundf")
                )
                val pilotRaceTime = line.substring(
                    startIndexAround + indexPosition("timeRacei"), finalIndexAround + indexPosition("timeRacef")
                )
                val pilotVelocity = line.substring(
                    startIndexAround + indexPosition("velocityAvi")
                )

                pilotCreator(pilotCod, pilotHour, pilotName, pilotLaps, pilotRaceTime, pilotVelocity)
            }
        }
    } catch (ex: Exception) {
        print("Ocorreu um erro ${ex.message}")
    }
}
