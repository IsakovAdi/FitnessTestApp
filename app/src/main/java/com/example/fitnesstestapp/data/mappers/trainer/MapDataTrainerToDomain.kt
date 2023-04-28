package com.example.fitnesstestapp.data.mappers.trainer

import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.TrainerDomain

class MapDataTrainerToDomain : Mapper<TrainerData, TrainerDomain> {
    override fun map(from: TrainerData) = from.run {
        TrainerDomain(
            trainerId = trainerId,
            trainerFullName = trainerFullName,
            trainerName = trainerName,
            trainerPosition = trainerPosition,
            imageUrl = imageUrl,
        )
    }
}