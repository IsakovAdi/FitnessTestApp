package com.example.fitnesstestapp.data.storage.mappers.trainer

import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.data.storage.model.TrainerStorage
import com.example.fitnesstestapp.domain.Mapper

class MapStorageTrainerListToData(
    private val mapper: Mapper<TrainerStorage, TrainerData>,
) : Mapper<List<TrainerStorage>, List<TrainerData>> {
    override fun map(from: List<TrainerStorage>) = from.run {
        map(mapper::map)
    }
}