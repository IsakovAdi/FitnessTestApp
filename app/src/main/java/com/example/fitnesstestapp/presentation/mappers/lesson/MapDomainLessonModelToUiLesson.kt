package com.example.fitnesstestapp.presentation.mappers.lesson

import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.presentation.models.LessonUi

class MapDomainLessonModelToUiLesson(
    private val mapper: Mapper<LessonsModel.Lesson, LessonUi.Lesson>,
) : Mapper<LessonsModel, LessonUi> {
    override fun map(from: LessonsModel): LessonUi = from.run {
        when (this) {
            is LessonsModel.Lesson -> mapper.map(this)
            is LessonsModel.LessonDate -> mapDate(this)
        }
    }

    private fun mapDate(lessonDate: LessonsModel.LessonDate): LessonUi.LessonDateUi =
        LessonUi.LessonDateUi(date = lessonDate.date)
}