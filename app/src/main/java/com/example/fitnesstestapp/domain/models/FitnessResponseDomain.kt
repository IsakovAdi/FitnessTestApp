package com.example.fitnesstestapp.domain.models

data class FitnessResponseDomain(
    val lessons: List<LessonDomain>,
    val trainers: List<TrainerDomain>,
)