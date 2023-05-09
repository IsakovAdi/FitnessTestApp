package com.example.fitnesstestapp.data.storage.mappers.lesson

import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.data.storage.model.LessonStorage
import com.example.fitnesstestapp.domain.Mapper

class MapStorageLessonListToData(
    private val mapper: Mapper<LessonStorage, LessonData>,
) : Mapper<List<LessonStorage>, List<LessonData>> {
    override fun map(from: List<LessonStorage>) = from.run {
        map(mapper::map)
    }
}