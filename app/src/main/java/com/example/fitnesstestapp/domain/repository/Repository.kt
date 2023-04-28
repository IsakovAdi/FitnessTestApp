package com.example.fitnesstestapp.domain.repository

import com.example.fitnesstestapp.domain.DataRequestState
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain

interface Repository {

    suspend fun getLessons(clubId: Int): DataRequestState<FitnessResponseDomain>

}