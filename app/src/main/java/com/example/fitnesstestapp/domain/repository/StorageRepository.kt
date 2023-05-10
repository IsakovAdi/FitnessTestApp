package com.example.fitnesstestapp.domain.repository

import com.example.fitnesstestapp.domain.models.FitnessResponseDomain

interface StorageRepository {

    suspend fun getResourcesFromStorage(): FitnessResponseDomain?

}