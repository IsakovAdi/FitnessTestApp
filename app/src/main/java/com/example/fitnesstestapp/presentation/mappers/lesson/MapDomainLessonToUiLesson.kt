package com.example.fitnesstestapp.presentation.mappers.lesson

import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.domain.models.TrainerDomain
import com.example.fitnesstestapp.presentation.models.LessonUi
import com.example.fitnesstestapp.presentation.models.TrainerUi

class MapDomainLessonToUiLesson(
    private val mapper: Mapper<TrainerDomain, TrainerUi>,
) : Mapper<LessonsModel.Lesson, LessonUi.Lesson> {
    override fun map(from: LessonsModel.Lesson) = from.run {
        LessonUi.Lesson(
            lessonName = lessonName,
            description = description,
            startTime = startTime,
            endTime = endTime,
            availableSlots = availableSlots,
            date = date,
            place = place,
            color = color,
            category = category,
            duration = duration,
            coach = if (coach != null) mapper.map(coach) else null
        )
    }

}