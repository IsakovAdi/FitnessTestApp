package com.example.fitnesstestapp.data.mappers.lesson

import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.LessonDomain

class MapDataLessonListToDomain(
    private val mapper: Mapper<LessonData, LessonDomain>,
) : Mapper<List<LessonData>, List<LessonDomain>> {
    override fun map(from: List<LessonData>) = from.run {
        map(mapper::map)
    }
}