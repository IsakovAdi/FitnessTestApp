package com.example.fitnesstestapp.data.cloud.mappers.lesson

import com.example.fitnesstestapp.data.cloud.models.LessonCloud
import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.domain.Mapper

class MapLessonToData:Mapper<LessonCloud, LessonData> {
    override fun map(from: LessonCloud) = from.run {
        LessonData(
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