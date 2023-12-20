package utils

import java.util.Date
import classes.pilot

import java.time.LocalTime
import javax.swing.text.Position

public var pilotMap = mutableListOf<pilot>()


fun pilotCreator(
    cod: String, hour: String, name: String, nLaps: String, timeRacing: String, velocity: String
) {

    var nLapsFormat = nLaps.toInt()
    var velocityFormat = velocity.replace(",", ".").toFloat()
    var hourFormat = LocalTime.parse(hour)
    var timeRacingFormat = LocalTime.parse("00:0" + timeRacing)

    try {
        var pilotGet = pilot(
            hour = hourFormat,
            cod = cod,
            name = name,
            nLaps = nLapsFormat,
            timeRacing = timeRacingFormat,
            velocity = velocityFormat
        )
        pilotMap.add(pilotGet)
    } catch (ex: Exception) {
        print(" Ocorreu um erro ${ex}")
    }
}


fun pilotFinishCreator(
    cod: String, name: String, nLaps: String, timeRacing: String, velocityAv: String, position: Int
) {

//    var nLapsFormat = nLaps.toInt()
//    var velocityFormat = velocity.replace(",", ".").toFloat()
//    var hourFormat = LocalTime.parse(hour)
//    var timeRacingFormat = LocalTime.parse("00:0" + timeRacing)

//    try {
//        var pilotGet = pilot(
//            hour = hourFormat,
//            cod = cod,
//            name = name,
//            nLaps = nLapsFormat,
//            timeRacing = timeRacingFormat,
//            velocity = velocityFormat
//        )
//        pilotMap.add(pilotGet)
//    } catch (ex: Exception) {
//        print(" Ocorreu um erro ${ex}")
//    }
}