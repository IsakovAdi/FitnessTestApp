package com.example.fitnesstestapp.data.cloud.source.lessons

import com.example.fitnesstestapp.data.cloud.api.FitnessApi
import com.example.fitnesstestapp.data.cloud.models.FitnessResponseCloud
import com.example.fitnesstestapp.data.cloud.source.ResponseHandler
import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.domain.DataRequestState
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import kotlinx.coroutines.withContext

class LessonsCloudDataSourceImpl(
    private val api: FitnessApi,
    private val mapFitnessResponseToData: Mapper<FitnessResponseCloud, FitnessResponseData>,
    private val responseHandler: ResponseHandler,
    private val dispatchersProvider: DispatchersProvider,
) : LessonsCloudDataSource {
    override suspend fun getLessons(clubId: Int): DataRequestState<FitnessResponseData> =
        withContext(dispatchersProvider.io()) {
            responseHandler.safeApiMapperCall(mapFitnessResponseToData) {
                api.getLessons(clubId = clubId)
            }
        }

}