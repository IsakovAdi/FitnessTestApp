package com.example.fitnesstestapp.presentation.mappers.base

import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.domain.models.TrainerDomain
import com.example.fitnesstestapp.presentation.models.FitnessResponseUi
import com.example.fitnesstestapp.presentation.models.LessonUi
import com.example.fitnesstestapp.presentation.models.TrainerUi

class MapDomainFitnessRespToUi(
    private val lessonMapper: Mapper<List<LessonDomain>, List<LessonUi>>,
    private val trainerMapper: Mapper<List<TrainerDomain>, List<TrainerUi>>,
) : Mapper<FitnessResponseDomain, FitnessResponseUi> {
    override fun map(from: FitnessResponseDomain) = from.run {
        FitnessResponseUi(
            lessons = lessonMapper.map(lessons),
            trainers = trainerMapper.map(trainers)
        )
    }
}