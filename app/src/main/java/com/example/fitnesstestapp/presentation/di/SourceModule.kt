package com.example.fitnesstestapp.presentation.di

import com.example.fitnesstestapp.data.cloud.api.FitnessApi
import com.example.fitnesstestapp.data.cloud.models.FitnessResponseCloud
import com.example.fitnesstestapp.data.cloud.source.ResponseHandler
import com.example.fitnesstestapp.data.cloud.source.ResponseHandlerImpl
import com.example.fitnesstestapp.data.cloud.source.lessons.LessonsCloudDataSource
import com.example.fitnesstestapp.data.cloud.source.lessons.LessonsCloudDataSourceImpl
import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.storage.db.FitnessResourcesStorageDao
import com.example.fitnesstestapp.data.storage.model.FitnessResourcesStorage
import com.example.fitnesstestapp.data.storage.source.StorageClubResourcesDataSource
import com.example.fitnesstestapp.data.storage.source.StorageClubResourcesDataSourceImpl
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SourceModule {

    @Provides
    fun provideResponseHandler(
        dispatchersProvider: DispatchersProvider,
    ): ResponseHandler = ResponseHandlerImpl(dispatchersProvider = dispatchersProvider)

    @Provides
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProvider.Base()

    @Provides
    fun provideLessonsCloudDataSource(
        api: FitnessApi,
        mapFitnessResponseToData: Mapper<FitnessResponseCloud, FitnessResponseData>,
        responseHandler: ResponseHandler,
        dispatchersProvider: DispatchersProvider,
    ): LessonsCloudDataSource = LessonsCloudDataSourceImpl(
        api = api,
        mapFitnessResponseToData = mapFitnessResponseToData,
        responseHandler = responseHandler,
        dispatchersProvider = dispatchersProvider,
    )

    @Provides
    fun provideStorageClubResourcesDataSourceImpl(
        dao: FitnessResourcesStorageDao,
        mapToStorage: Mapper<FitnessResponseData, FitnessResourcesStorage>,
        mapFromStorage: Mapper<FitnessResourcesStorage, FitnessResponseData>,
        dispatchersProvider: DispatchersProvider,
    ): StorageClubResourcesDataSource = StorageClubResourcesDataSourceImpl(
        dao = dao,
        mapToStorage = mapToStorage,
        mapFromStorage = mapFromStorage,
        dispatchersProvider = dispatchersProvider,
    )
}