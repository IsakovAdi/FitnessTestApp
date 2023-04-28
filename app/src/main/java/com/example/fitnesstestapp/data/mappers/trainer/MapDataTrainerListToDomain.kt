package com.example.fitnesstestapp.data.mappers.trainer

import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.TrainerDomain

class MapDataTrainerListToDomain(
    private val mapper: Mapper<TrainerData, TrainerDomain>,
) : Mapper<List<TrainerData>, List<TrainerDomain>> {
    override fun map(from: List<TrainerData>) = from.run {
        map(mapper::map)
    }
}