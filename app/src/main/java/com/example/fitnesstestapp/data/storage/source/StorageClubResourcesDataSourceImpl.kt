package com.example.fitnesstestapp.data.storage.source

import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.storage.db.FitnessResourcesStorageDao
import com.example.fitnesstestapp.data.storage.model.FitnessResourcesStorage
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import kotlinx.coroutines.withContext

class StorageClubResourcesDataSourceImpl(
    private val dao: FitnessResourcesStorageDao,
    private val mapToStorage: Mapper<FitnessResponseData, FitnessResourcesStorage>,
    private val mapFromStorage: Mapper<FitnessResourcesStorage, FitnessResponseData>,
    private val dispatchersProvider: DispatchersProvider,
) : StorageClubResourcesDataSource {
    override suspend fun saveResourcesToStorage(resource: FitnessResponseData) =
        withContext(dispatchersProvider.io()) {
            dao.saveToStorage(mapToStorage.map(resource))
        }

    override suspend fun getResourcesFromStorage(): FitnessResponseData? =
        withContext(dispatchersProvider.io()) {
            val resource = dao.getAllClubResourcesFromCache()
            if (resource != null) mapFromStorage.map(resource)
            else null
        }


    override suspend fun clearCache() = dao.clearCache()
}