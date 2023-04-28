package com.example.fitnesstestapp.presentation.mappers.trainer

import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.TrainerDomain
import com.example.fitnesstestapp.presentation.models.TrainerUi

class MapDomainTrainerListToUi(
    private val mapper: Mapper<TrainerDomain, TrainerUi>,
) : Mapper<List<TrainerDomain>, List<TrainerUi>> {
    override fun map(from: List<TrainerDomain>) = from.run {
        map(mapper::map)
    }
}