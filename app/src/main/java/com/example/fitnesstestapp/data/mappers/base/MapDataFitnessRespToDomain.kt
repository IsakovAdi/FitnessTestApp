package com.example.fitnesstestapp.data.mappers.base

import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.domain.models.TrainerDomain

class MapDataFitnessRespToDomain(
    private val lessonMapper: Mapper<List<LessonData>, List<LessonDomain>>,
    private val trainerMapper: Mapper<List<TrainerData>, List<TrainerDomain>>,
) : Mapper<FitnessResponseData, FitnessResponseDomain> {
    override fun map(from: FitnessResponseData) = from.run {
        FitnessResponseDomain(
            lessons = lessonMapper.map(lessons),
            trainers = trainerMapper.map(trainers)
        )
    }
}