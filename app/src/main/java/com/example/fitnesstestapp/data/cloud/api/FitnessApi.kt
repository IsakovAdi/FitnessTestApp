package com.example.fitnesstestapp.data.cloud.api

import com.example.fitnesstestapp.data.cloud.constants.Endpoints
import com.example.fitnesstestapp.data.cloud.models.FitnessResponseCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FitnessApi {

    @GET(Endpoints.GET_LESSONS)
    suspend fun getLessons(
        @Query("club_id") clubId: Int,
    ): Response<FitnessResponseCloud>
}