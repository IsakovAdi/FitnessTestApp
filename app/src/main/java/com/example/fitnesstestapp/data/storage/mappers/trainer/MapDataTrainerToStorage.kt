package com.example.fitnesstestapp.data.storage.mappers.trainer

import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.data.storage.model.TrainerStorage
import com.example.fitnesstestapp.domain.Mapper

class MapDataTrainerToStorage : Mapper<TrainerData, TrainerStorage> {
    override fun map(from: TrainerData) = from.run {
        TrainerStorage(
            trainerId = trainerId,
            trainerFullName = trainerFullName,
            trainerName = trainerName,
            trainerPosition = trainerPosition,
            imageUrl = imageUrl,
        )
    }
}