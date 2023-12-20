package utils

import java.io.File
import kotlin.String
import classes.pilot

fun reportReader() {
    val archiveDirectory = "src/main/resources/report.txt/"
    var listInfo = ArrayList<Any?>()

    fun indexPosition(prop: String): Int {
        var value = 0
        if (prop == "aroundi") value = 5
        else if (prop == "aroundf") value = 6
        else if (prop == "timeRacei") value = 7
        else if (prop == "timeRacef") value = 15
        else if (prop == "velocityAvi") value = 16
        return value
    }

    try {
        val archive = File(archiveDirectory)
        val lineRead = archive.bufferedReader()

        lineRead.useLines { lines ->
            lines.forEach { line ->
                var pilotCod = line.substring(13, 16)
                var pilotNameSplit = line.replace(Regex("[^a-zA-Z]"), "")
                var pilotName = ("${pilotNameSplit[0]}.${pilotNameSplit.drop(1)}")
                var pilotHour = line.substring(0, 12)

                var startIndexAround = pilotHour.length + pilotCod.length + pilotName.length
                var finalIndexAround = pilotHour.length + pilotCod.length + pilotName.length

                var pilotLaps = line.substring(
                    startIndexAround + indexPosition("aroundi"), finalIndexAround + indexPosition("aroundf")
                )
                var pilotRaceTime = line.substring(
                    startIndexAround + indexPosition("timeRacei"), finalIndexAround + indexPosition("timeRacef")
                )
                var pilotVelocity = line.substring(
                    startIndexAround + indexPosition("velocityAvi")
                )

                pilotCreator(pilotCod, pilotHour, pilotName, pilotLaps, pilotRaceTime, pilotVelocity)

//                var sublistInfo = listOf(pilotCod, pilotName, pilotHour, pilotLaps, pilotRaceTime, pilotVelocity)
//                listInfo.add(sublistInfo)

            }
        }
    } catch (ex: Exception) {
        print("Ocorreu um erro ${ex.message}")
    }

}
