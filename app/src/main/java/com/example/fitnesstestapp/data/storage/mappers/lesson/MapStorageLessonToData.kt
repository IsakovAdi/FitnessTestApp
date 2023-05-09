package com.example.fitnesstestapp.data.storage.mappers.lesson

import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.data.storage.model.LessonStorage
import com.example.fitnesstestapp.domain.Mapper

class MapStorageLessonToData : Mapper<LessonStorage, LessonData> {
    override fun map(from: LessonStorage) = from.run {
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