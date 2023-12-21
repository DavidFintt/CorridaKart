package utils.dataAnalyzer

import utils.pilotMap
import java.time.LocalTime
import java.text.DecimalFormat
import utils.secondsToDateTime

private val data = pilotMap

fun finishingInfo() {
    var totalTime = LocalTime.now()
    var output = "Tempo total da corrida ${secondsToDateTime(data.maxBy { it.hour }.hour.toSecondOfDay().toLong() - data.minBy { it.hour }.hour.toSecondOfDay().toLong())} \n"
    output += "Melhor volta da corrida${data.minBy { it.timeRacing }?.timeRacing} \n \n"
    data.sortedWith(compareBy({ it.hour }, { it.nLaps })).reversed().distinctBy { it.cod }.reversed()
        .forEachIndexed { index, element ->
            if (index == 0) {
                totalTime = element.hour
            }

            val pilotInfo = data.filter { it.cod == element.cod }
            val decimalFormat = DecimalFormat("#.##")

            output += "\n Posição: ${index + 1}"
            output += "\n Codigo do piloto: ${element.cod}"
            output += "\n Nome: ${element.name}"
            output += "\n Diferença do primeiro colocado +${element.hour.toSecondOfDay() - totalTime.toSecondOfDay()} segundos"
            output += "\n Numero de voltas ${element.nLaps}"
            output += "\n Tempo total do piloto ${pilotInfo.sumOf { it.timeRacing.toSecondOfDay() }}"
            output += "\n Melhor tempo do piloto:  ${pilotInfo.minBy { it.timeRacing }?.timeRacing}"
            output += "\n Numero de voltas ${element.nLaps}"
            output += "\n Velocidade média ${decimalFormat.format(pilotInfo.sumOf { it.velocity.toDouble() } / element.nLaps)}\n"
            output += "=".repeat(50)
        }

    println(output)
}
