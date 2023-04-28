package com.example.fitnesstestapp.data.cloud.mappers.base

import com.example.fitnesstestapp.data.cloud.models.FitnessResponseCloud
import com.example.fitnesstestapp.data.cloud.models.LessonCloud
import com.example.fitnesstestapp.data.cloud.models.TrainerCloud
import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.domain.Mapper

class MapFitnessRespToData(
    private val lessonMapper: Mapper<List<LessonCloud>, List<LessonData>>,
    private val trainerMapper: Mapper<List<TrainerCloud>, List<TrainerData>>,
) : Mapper<FitnessResponseCloud, FitnessResponseData> {
    override fun map(from: FitnessResponseCloud) = from.run {
        FitnessResponseData(
            lessons = lessonMapper.map(lessons),
            trainers = trainerMapper.map(trainers)
        )
    }
}