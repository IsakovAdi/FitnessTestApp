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

class MapStorageResponseToData(
    private val lessonMapper: Mapper<List<LessonStorage>, List<LessonData>>,
    private val trainerMapper: Mapper<List<TrainerStorage>, List<TrainerData>>,
) : Mapper<FitnessResourcesStorage, FitnessResponseData> {
    override fun map(from: FitnessResourcesStorage) = from.run {
        FitnessResponseData(
            lessons = lessonMapper.map(lessons),
            trainers = trainerMapper.map(trainers),
            savedDate = convertStringToDate(savedDate)
        )
    }

    private fun convertStringToDate(date: String): LocalDateTime {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        return LocalDateTime.parse(date, formatter)

    }
}