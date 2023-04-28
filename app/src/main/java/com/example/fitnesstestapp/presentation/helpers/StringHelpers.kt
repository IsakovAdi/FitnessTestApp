package com.example.fitnesstestapp.presentation.helpers

import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT = "EEEE dd MMMM"

val UNIX_START_DATE = Date(0L)

/* Приводим дату в необходимый для нас формат из String*/
fun String.formatISOAsDate() = try {
    val dateArray = this.split("-").toTypedArray()
    val year = dateArray[0].toInt()-1
    val month = dateArray[1].toInt()-1
    val day = dateArray[2].toInt()
    val date = Date(year, month, day)

    val format = SimpleDateFormat(DATE_FORMAT, Locale("RU"))
    format.format(date) ?: UNIX_START_DATE
} catch (e: Exception) {
    UNIX_START_DATE
}