package com.example.fitnesstestapp.data.cloud.mappers.trainer

import com.example.fitnesstestapp.data.cloud.models.TrainerCloud
import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.domain.Mapper

class MapCloudTrainerToData : Mapper<TrainerCloud, TrainerData> {
    override fun map(from: TrainerCloud) = from.run {
        TrainerData(
            trainerId = trainerId,
            trainerFullName = trainerFullName,
            trainerName = trainerName,
            trainerPosition = trainerPosition,
            imageUrl = imageUrl,
        )
    }
}