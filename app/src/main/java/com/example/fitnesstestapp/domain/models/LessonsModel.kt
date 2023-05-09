package com.example.fitnesstestapp.domain.models


sealed interface LessonsModel {
    data class Lesson(
        val lessonName: String,
        val description: String,
        val startTime: String,
        val endTime: String,
        val availableSlots: Int,
        val date: String,
        val coach: TrainerDomain?,
        val place: String,
        val color: String,
        val category: String,
        val duration: String,
    ) : LessonsModel

    data class LessonDate(
        val date: String,
    ) : LessonsModel
}
