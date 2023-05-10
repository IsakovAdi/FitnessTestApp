package com.example.fitnesstestapp.data.repositoryImpl

import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.storage.source.StorageClubResourcesDataSource
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain
import com.example.fitnesstestapp.domain.repository.StorageRepository

class StorageRepositoryImpl(
    private val dispatchersProvider: DispatchersProvider,
    private val mapper: Mapper<FitnessResponseData, FitnessResponseDomain>,
    private val source: StorageClubResourcesDataSource,
) : StorageRepository {
    override suspend fun getResourcesFromStorage(): FitnessResponseDomain? {
        val resource = source.getResourcesFromStorage()
        return if (resource != null) mapper.map(resource) else null
    }

}