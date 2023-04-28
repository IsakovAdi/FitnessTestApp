package com.example.fitnesstestapp.data.cloud.mappers.lesson

import com.example.fitnesstestapp.data.cloud.models.LessonCloud
import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.domain.Mapper

class MapLessonListToData(
    private val mapper: Mapper<LessonCloud, LessonData>,
) : Mapper<List<LessonCloud>, List<LessonData>> {
    override fun map(from: List<LessonCloud>) = from.run {
        map(mapper::map)
    }
}