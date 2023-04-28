package com.example.fitnesstestapp.data.cloud.models

import com.google.gson.annotations.SerializedName
import java.util.Date

class LessonCloud(
    @SerializedName("name") val lessonName: String,
    @SerializedName("description") val description: String,
    @SerializedName("place") val place: String,
    @SerializedName("coach_id") val coachId: String,
    @SerializedName("startTime") val startTime: String,
    @SerializedName("endTime") val endTime: String,
    @SerializedName("date") val date: String,
    @SerializedName("available_slots") val availableSlots: Int,
    @SerializedName("commercial") val isCommercial: Boolean,
    @SerializedName("client_recorded") val isClient_recorded: Boolean,
    @SerializedName("is_cancelled") val isCancelled: Boolean,
    @SerializedName("tab") val category: String,
    @SerializedName("color") val color: String,
    @SerializedName("tab_id") val tabId: Int,
)