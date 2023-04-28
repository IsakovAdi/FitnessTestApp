package com.example.fitnesstestapp.data.cloud.source.lessons

import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.domain.DataRequestState

interface LessonsCloudDataSource {
    suspend fun getLessons(clubId: Int):DataRequestState<FitnessResponseData>
}