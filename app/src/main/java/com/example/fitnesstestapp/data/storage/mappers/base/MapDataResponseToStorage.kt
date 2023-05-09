package com.example.fitnesstestapp.data.storage.mappers.base

import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.data.storage.model.FitnessResourcesStorage
import com.example.fitnesstestapp.data.storage.model.LessonStorage
import com.example.fitnesstestapp.data.storage.model.TrainerStorage
import com.example.fitnesstestapp.domain.Mapper
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MapDataResponseToStorage(
    private val lessonMapper: Mapper<List<LessonData>, List<LessonStorage>>,
    private val trainerMapper: Mapper<List<TrainerData>, List<TrainerStorage>>,
) : Mapper<FitnessResponseData, FitnessResourcesStorage> {
    override fun map(from: FitnessResponseData) = from.run {
        FitnessResourcesStorage(
            id = 0,
            lessons = lessonMapper.map(lessons),
            trainers = trainerMapper.map(trainers),
            savedDate = getCurrentDate()
        )
    }

    private fun getCurrentDate(): String =
        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
}