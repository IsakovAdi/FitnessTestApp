package com.example.fitnesstestapp.data.mappers.lesson

import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.LessonDomain

class MapDataLessonToDomain : Mapper<LessonData, LessonDomain> {
    override fun map(from: LessonData) = from.run {
        LessonDomain(
            lessonName = lessonName,
            description = description,
            place = place,
            coachId = coachId,
            startTime = startTime,
            endTime = endTime,
            date = date,
            availableSlots = availableSlots,
            isCommercial = isCommercial,
            isClient_recorded = isClient_recorded,
            isCancelled = isCancelled,
            category = category,
            color = color,
            tabId = tabId,
        )
    }
}