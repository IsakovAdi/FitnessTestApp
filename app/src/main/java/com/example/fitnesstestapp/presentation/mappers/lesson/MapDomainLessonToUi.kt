package com.example.fitnesstestapp.presentation.mappers.lesson

import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.presentation.models.LessonUi

class MapDomainLessonToUi : Mapper<LessonDomain, LessonUi> {
    override fun map(from: LessonDomain) = from.run {
        LessonUi(
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