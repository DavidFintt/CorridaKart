package utils

import java.sql.Time
import java.time.LocalTime

data class DateComponents(
    val minutes: Long,
    val seconds: Long,
    val milliseconds: Long
)

fun dateManipulation(decimalDate: Double): DateComponents {
    val minutes = (decimalDate).toLong()
    val seconds = ((decimalDate % 1) * 60).toLong()
    val miliSeconds = ((decimalDate % 1) * 1000).toLong() * 1_000_000

    return DateComponents(minutes, seconds, miliSeconds)

}