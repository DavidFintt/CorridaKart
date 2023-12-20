import utils.reportReader
import utils.countHours
import utils.finishingInfo

fun main() {

//  Inicio: ler o arquivo de log .txt, separar as strings e criar os objetos
    reportReader()

    println("Tempo total de corrida: ${countHours()}")

    finishingInfo()

}

