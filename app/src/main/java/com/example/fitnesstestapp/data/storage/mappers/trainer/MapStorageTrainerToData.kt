package com.example.fitnesstestapp.data.storage.mappers.trainer

import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.data.storage.model.TrainerStorage
import com.example.fitnesstestapp.domain.Mapper

class MapStorageTrainerToData : Mapper<TrainerStorage, TrainerData> {
    override fun map(from: TrainerStorage) = from.run {
        TrainerData(
            trainerId = trainerId,
            trainerFullName = trainerFullName,
            trainerName = trainerName,
            trainerPosition = trainerPosition,
            imageUrl = imageUrl,
        )
    }
}