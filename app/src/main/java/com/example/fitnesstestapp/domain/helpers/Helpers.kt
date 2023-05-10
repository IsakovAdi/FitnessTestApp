package com.example.fitnesstestapp.domain.helpers

import android.annotation.SuppressLint
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.domain.models.TrainerDomain
import java.text.SimpleDateFormat
import java.util.*

private val UNIX_START_DATE = Date(0L)

/*Из времени начало занятий и конца занятий парсим продолжительность*/

@SuppressLint("SimpleDateFormat")
fun formatDuration(start: String, end: String): String {
    val format = SimpleDateFormat("HH:mm")
    val startTime = format.parse(start)
    val endTime = format.parse(end)
    val duration = ((endTime?.time ?: UNIX_START_DATE.time) - (startTime?.time
        ?: UNIX_START_DATE.time)) / 60000
    return timeFormat(duration.toInt())
}

/*Из продолжительности занятий в минутах парсим в необходимый для нас формат*/
private fun timeFormat(minutes: Int): String {
    val hours = (minutes / 60)
    val mins = (minutes % 60)
    return if (hours > 0 && mins > 0) {
        String.format("%2dч. %02dмин.", hours, mins)
    } else if (hours == 0) {
        String.format("%02dмин.", mins)
    } else if (mins == 0) {
        String.format("%2dч.", hours, mins)
    } else "No value"
}

/* Из модельки занятий Domain преобразовываем в необходимую для нас модельку для отображения в ui */

fun mapLessonDomainToLessonModel(
    lessonDomain: LessonDomain, trainers: List<TrainerDomain>,
) = lessonDomain.run {
    LessonsModel.Lesson(
        lessonName = lessonName,
        startTime = startTime,
        endTime = endTime,
        availableSlots = availableSlots,
        coach = getTrainerName(coachId = coachId, trainers = trainers),
        place = place,
        color = color,
        category = category,
        duration = formatDuration(startTime, endTime),
        description = description,
        date = date
    )
}


/* Из коллекций тренеров получаем имя тренера для занятия по идентификатору */
private fun getTrainerName(coachId: String, trainers: List<TrainerDomain>) = trainers.filter {
    it.trainerId.equals(coachId)
}.map {
    it
}.firstOrNull()