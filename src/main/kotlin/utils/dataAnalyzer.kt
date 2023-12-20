package utils

import classes.pilot
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import utils.dateManipulation

private var data = pilotMap


fun countHours(): String {

    var countMax = 0.0
    var countMin = 0.0
    for (dt in data) {
        val dtHour = dt.hour.toSecondOfDay() / 3600.0
        if (countMax == 0.0) {
            countMax = dtHour
            countMin = dtHour
        }
        if (dtHour > countMax) {
            countMax = dtHour
        }
        if (dtHour < countMin) {
            countMin = dtHour
        }
    }

    val decimalHour = ((countMax - countMin) * 60)
    val dateInfo = dateManipulation((decimalHour))

    val convertMinutes =
        LocalTime.MIN.plusMinutes(dateInfo.minutes).plusSeconds(dateInfo.seconds).plusNanos(dateInfo.milliseconds)

    val timePattern = DateTimeFormatter.ofPattern("HH:mm:ss.SSSS")

    val formattedTime = timePattern.format(convertMinutes)

    return formattedTime
}

fun finishingInfo() {
    var listCod = mutableListOf<String>()
    var listPilot = mutableListOf<Map<String, Any?>>()
    var timeF = 0.0
    var bestLap = 0
    var bestTime = LocalTime.now()
    var nLaps = 0
    var pilotName = ""
    var timeRacingF = 0.0
    var nLapF = 0

    for (dt in data) {
        if (!listCod.contains(dt.cod)) {
            listCod.add(dt.cod)
        }
    }

    for ((index, cod) in listCod.sorted().withIndex()) {
        val mapPilot = mutableMapOf<String, Any?>()
        var countLoop = 0
        data.forEach {
            if (countLoop == 0) {
                timeRacingF = it.timeRacing.toSecondOfDay().toFloat() / 3600.0
            }
            if (it.cod == cod) {
                var timeFinish = it.timeRacing.toSecondOfDay().toFloat() / 3600.0
                if (countLoop == 0) {
                    timeF = it.timeRacing.toSecondOfDay().toFloat() / 3600.0
                    nLaps = it.nLaps
                }
                if (timeFinish <= timeF && countLoop > 0) {
                    bestLap = it.nLaps
                    bestTime = it.timeRacing
                    timeF = it.timeRacing.toSecondOfDay().toFloat() / 3600.0
                }
                if (it.nLaps > nLaps) {
                    nLaps = it.nLaps
                }

                pilotName = it.name
                countLoop = 1
            }
        }

        mapPilot["cod"] = cod
        mapPilot["nome"] = pilotName
        mapPilot["melhorTempo"] = bestTime
        mapPilot["melhorVolta"] = bestLap
        mapPilot["numeroDeVoltas"] = nLaps

        listPilot.add((mapPilot))
    }

    listPilot.forEach {
        println("")
        println("Codigo do piloto: ${it["cod"]}")
        println("Nome do piloto: ${it["nome"]}")
        println("Melhor tempo: ${it["melhorTempo"]}")
        println("Melhor volta: ${it["melhorVolta"]}")
        println("Numero de voltas: ${it["numeroDeVoltas"]}")
        println("=".repeat(30))
    }

}



