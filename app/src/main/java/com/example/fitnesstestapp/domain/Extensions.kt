package com.example.fitnesstestapp.domain

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

private const val DATE_FORMAT = "EEEE dd MMMM"

val UNIX_START_DATE = Date(0L)

/* Приводим дату в необходимый для нас формат из String*/
fun String.formatISOAsDate() = try {
    val dateArray = this.split("-").toTypedArray()
    val year = dateArray.firstOrNull()?.toInt() ?: 0
    val month = dateArray[1].toInt()
    val day = dateArray.lastOrNull()?.toInt() ?: 0
    val date = Date(year, month, day)

    val format = SimpleDateFormat(DATE_FORMAT, Locale("RU"))
    format.format(date) ?: UNIX_START_DATE
} catch (e: Exception) {
    UNIX_START_DATE
}




