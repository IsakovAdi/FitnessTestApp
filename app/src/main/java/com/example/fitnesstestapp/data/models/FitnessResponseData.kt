package com.example.fitnesstestapp.data.models

import java.time.LocalDateTime

class FitnessResponseData(
    val lessons: List<LessonData>,
    val trainers: List<TrainerData>,
    var savedDate: LocalDateTime? = null,
)