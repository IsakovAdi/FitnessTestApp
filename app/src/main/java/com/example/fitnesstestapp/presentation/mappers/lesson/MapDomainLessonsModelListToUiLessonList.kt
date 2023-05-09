package com.example.fitnesstestapp.presentation.mappers.lesson

import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.presentation.models.LessonUi

class MapDomainLessonsModelListToUiLessonList(
    private val mapper: Mapper<LessonsModel, LessonUi>,
) : Mapper<List<LessonsModel>, List<LessonUi>> {
    override fun map(from: List<LessonsModel>) = from.run {
        map(mapper::map)
    }

}