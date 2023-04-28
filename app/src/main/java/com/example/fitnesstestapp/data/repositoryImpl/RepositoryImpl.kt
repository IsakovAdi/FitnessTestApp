package com.example.fitnesstestapp.data.repositoryImpl

import com.example.fitnesstestapp.data.cloud.source.lessons.LessonsCloudDataSource
import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.domain.DataRequestState
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain
import com.example.fitnesstestapp.domain.repository.Repository

class RepositoryImpl(
    private val cloudDataSource: LessonsCloudDataSource,
    private val mapper: Mapper<FitnessResponseData, FitnessResponseDomain>,
) : Repository {
    override suspend fun getLessons(clubId: Int): DataRequestState<FitnessResponseDomain> =
        cloudDataSource.getLessons(clubId = clubId).map(mapper = mapper)

}