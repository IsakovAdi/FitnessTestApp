package com.example.fitnesstestapp.presentation.di

import com.example.fitnesstestapp.domain.interactors.GetLessonsUseCase
import com.example.fitnesstestapp.domain.interactors.GetLessonsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class InteractorsModule {

    @Binds
    abstract fun bindGetLessonsUsecase(
        implementation:GetLessonsUseCaseImpl
    ):GetLessonsUseCase

}