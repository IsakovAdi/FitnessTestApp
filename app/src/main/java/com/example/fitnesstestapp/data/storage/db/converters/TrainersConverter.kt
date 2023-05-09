package com.example.fitnesstestapp.data.storage.db.converters

import androidx.room.TypeConverter
import com.example.fitnesstestapp.data.storage.model.TrainerStorage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TrainersConverter {
    @TypeConverter
    fun toStorage(lessons: List<TrainerStorage>): String {
        val type = object : TypeToken<List<TrainerStorage>>() {}.type
        return Gson().toJson(lessons, type)
    }

    @TypeConverter
    fun fromStorage(lessons: String?): List<TrainerStorage> {
        val type = object : TypeToken<List<TrainerStorage>>() {}.type
        return Gson().fromJson(lessons, type)
    }
}