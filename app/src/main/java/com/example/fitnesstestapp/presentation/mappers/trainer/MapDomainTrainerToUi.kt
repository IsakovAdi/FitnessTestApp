package com.example.fitnesstestapp.presentation.mappers.trainer

import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.TrainerDomain
import com.example.fitnesstestapp.presentation.models.TrainerUi

class MapDomainTrainerToUi : Mapper<TrainerDomain, TrainerUi> {
    override fun map(from: TrainerDomain) = from.run {
        TrainerUi(
            trainerId = trainerId,
            trainerFullName = trainerFullName,
            trainerName = trainerName,
            trainerPosition = trainerPosition,
            imageUrl = imageUrl,
        )
    }
}