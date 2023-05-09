package com.example.fitnesstestapp.data.storage.db.converters

import androidx.room.TypeConverter
import com.example.fitnesstestapp.data.storage.model.LessonStorage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LessonsConverter {
    @TypeConverter
    fun toStorage(lessons: List<LessonStorage>): String {
        val type = object : TypeToken<List<LessonStorage>>() {}.type
        return Gson().toJson(lessons, type)
    }

    @TypeConverter
    fun fromStorage(lessons: String?): List<LessonStorage> {
        val type = object : TypeToken<List<LessonStorage>>() {}.type
        return Gson().fromJson(lessons, type)
    }
}