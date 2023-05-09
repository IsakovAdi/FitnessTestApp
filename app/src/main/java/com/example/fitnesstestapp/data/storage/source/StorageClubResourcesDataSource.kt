package com.example.fitnesstestapp.data.storage.source

import com.example.fitnesstestapp.data.models.FitnessResponseData

interface StorageClubResourcesDataSource {
    suspend fun saveResourcesToStorage(resource: FitnessResponseData)

    suspend fun getResourcesFromStorage(): FitnessResponseData?

    suspend fun clearCache()
}