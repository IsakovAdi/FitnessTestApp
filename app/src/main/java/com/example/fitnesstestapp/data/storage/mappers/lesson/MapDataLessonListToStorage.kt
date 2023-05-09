package com.example.fitnesstestapp.data.storage.mappers.lesson

import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.data.storage.model.LessonStorage
import com.example.fitnesstestapp.domain.Mapper

class MapDataLessonListToStorage(
    private val mapper: Mapper<LessonData, LessonStorage>,
) : Mapper<List<LessonData>, List<LessonStorage>> {
    override fun map(from: List<LessonData>) = from.run {
        map(mapper::map)
    }
}