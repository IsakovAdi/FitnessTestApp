package com.example.fitnesstestapp.data.cloud.models

import com.google.gson.annotations.SerializedName

class TrainerCloud(
    @SerializedName("id") val trainerId: String,
    @SerializedName("full_name") val trainerFullName: String,
    @SerializedName("name") val trainerName: String,
    @SerializedName("position") val trainerPosition: String,
    @SerializedName("image_url") val imageUrl: String,
)