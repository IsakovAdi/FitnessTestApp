package com.example.fitnesstestapp.domain.models


sealed interface LessonsModel {

    data class Lesson(
        val lessonName: String,
        val startTime: String,
        val endTime: String,
        val availableSlots: Int,
        val coachName: String,
        val place: String,
        val color: String,
        val category: String,
        val duration: String,
    ) : LessonsModel

    data class LessonDate(
        val date: String,
    ) : LessonsModel
}
