package com.example.fitnesstestapp.presentation.di

import com.example.fitnesstestapp.domain.interactors.cloud.GetLessonsUseCase
import com.example.fitnesstestapp.domain.interactors.cloud.GetLessonsUseCaseImpl
import com.example.fitnesstestapp.domain.interactors.sotorage.GetLessonResourceFromStorageUseCase
import com.example.fitnesstestapp.domain.interactors.sotorage.GetLessonResourceFromStorageUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class InteractorsModule {

    @Binds
    abstract fun bindGetLessonsUsecase(
        implementation: GetLessonsUseCaseImpl,
    ): GetLessonsUseCase

    @Binds
    abstract fun bindGetLessonsFormStorageUseCase(
        implementation: GetLessonResourceFromStorageUseCaseImpl,
    ): GetLessonResourceFromStorageUseCase
}