package com.example.fitnesstestapp.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


sealed interface LessonUi {
@Parcelize
    class Lesson(
        val lessonName: String,
        val description: String,
        val startTime: String,
        val endTime: String,
        val availableSlots: Int,
        val date: String,
        val coach: TrainerUi?,
        val place: String,
        val color: String,
        val category: String,
        val duration: String,
    ) : LessonUi, Parcelable

    class LessonDateUi(
        val date: String,
    ) : LessonUi

}