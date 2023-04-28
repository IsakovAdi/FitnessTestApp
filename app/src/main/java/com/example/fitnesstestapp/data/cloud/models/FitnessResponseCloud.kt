package com.example.fitnesstestapp.data.cloud.models

import com.google.gson.annotations.SerializedName

class FitnessResponseCloud(
    @SerializedName("lessons") val lessons: List<LessonCloud>,
    @SerializedName("trainers") val trainers: List<TrainerCloud>,
)