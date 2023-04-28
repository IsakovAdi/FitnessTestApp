package com.example.fitnesstestapp.data.cloud.mappers.trainer

import com.example.fitnesstestapp.data.cloud.models.TrainerCloud
import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.domain.Mapper

class MapCloudTrainerListToData(
    private val mapper: Mapper<TrainerCloud, TrainerData>,
) : Mapper<List<TrainerCloud>, List<TrainerData>> {
    override fun map(from: List<TrainerCloud>) = from.run {
        map(mapper::map)
    }
}