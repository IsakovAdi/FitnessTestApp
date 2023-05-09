package com.example.fitnesstestapp.data.repositoryImpl

import com.example.fitnesstestapp.data.cloud.source.lessons.LessonsCloudDataSource
import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.storage.source.StorageClubResourcesDataSource
import com.example.fitnesstestapp.domain.DataRequestState
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain
import com.example.fitnesstestapp.domain.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import java.time.LocalDateTime

class RepositoryImpl(
    private val storageDataSource: StorageClubResourcesDataSource,
    private val cloudDataSource: LessonsCloudDataSource,
    private val mapper: Mapper<FitnessResponseData, FitnessResponseDomain>,
    private val dispatchersProvider: DispatchersProvider,
) : Repository {
    override suspend fun getLessons(clubId: Int): DataRequestState<FitnessResponseDomain> {
        val resource = checkCache().await()
        return if (resource != null && !isRefresh(resource.savedDate!!)) {
            DataRequestState.Success(resource).map(mapper = mapper)
        } else {
            getFromCloudAndSaveToCache(cloudDataSource.getLessons(clubId = clubId)).map(mapper = mapper)
        }
    }

    private fun checkCache(): Deferred<FitnessResponseData?> =
        CoroutineScope(dispatchersProvider.io()).async {
            storageDataSource.getResourcesFromStorage()
        }

    private suspend fun getFromCloudAndSaveToCache(
        resource: DataRequestState<FitnessResponseData>,
    ): DataRequestState<FitnessResponseData> {
        when (resource) {
            is DataRequestState.Success -> {
                storageDataSource.clearCache()
                storageDataSource.saveResourcesToStorage(
                    resource.data
                )
            }
            is DataRequestState.Error -> Throwable(resource.error)
        }
        return resource
    }

    private fun isRefresh(savedDate: LocalDateTime): Boolean {
        val currentTime = LocalDateTime.now()
        val diff = currentTime.minute - savedDate.minute
        return diff >= 2
    }
}