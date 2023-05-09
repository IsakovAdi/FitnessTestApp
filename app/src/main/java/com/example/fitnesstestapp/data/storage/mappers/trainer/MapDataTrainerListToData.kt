package com.example.fitnesstestapp.data.storage.mappers.trainer

import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.data.storage.model.TrainerStorage
import com.example.fitnesstestapp.domain.Mapper

class MapDataTrainerListToData(
    private val mapper: Mapper<TrainerData, TrainerStorage>,
) : Mapper<List<TrainerData>, List<TrainerStorage>> {
    override fun map(from: List<TrainerData>) = from.run {
        map(mapper::map)
    }
}