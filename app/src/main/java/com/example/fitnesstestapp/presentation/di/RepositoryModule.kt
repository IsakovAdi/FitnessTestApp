package com.example.fitnesstestapp.presentation.di

import android.content.Context
import com.example.fitnesstestapp.data.cloud.base.ResourceProvider
import com.example.fitnesstestapp.data.cloud.source.lessons.LessonsCloudDataSource
import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.repositoryImpl.RepositoryImpl
import com.example.fitnesstestapp.data.storage.source.StorageClubResourcesDataSource
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain
import com.example.fitnesstestapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideResourceProvider(
        @ApplicationContext context: Context,
    ): ResourceProvider = ResourceProvider.Base(context = context)

    @Provides
    fun provideRepository(
        storageDataSource: StorageClubResourcesDataSource,
        cloudDataSource: LessonsCloudDataSource,
        mapper: Mapper<FitnessResponseData, FitnessResponseDomain>,
        dispatchersProvider: DispatchersProvider,
    ): Repository = RepositoryImpl(
        storageDataSource = storageDataSource,
        cloudDataSource = cloudDataSource,
        mapper = mapper,
        dispatchersProvider = dispatchersProvider
    )
}