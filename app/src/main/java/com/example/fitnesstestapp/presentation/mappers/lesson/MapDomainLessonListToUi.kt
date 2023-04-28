package com.example.fitnesstestapp.presentation.mappers.lesson

import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.presentation.models.LessonUi

class MapDomainLessonListToUi(
    private val mapper: Mapper<LessonDomain, LessonUi>,
) : Mapper<List<LessonDomain>, List<LessonUi>> {
    override fun map(from: List<LessonDomain>) = from.run {
        map(mapper::map)
    }
}