package com.example.fitnesstestapp.domain.interactors.sotorage

import com.example.fitnesstestapp.domain.models.LessonsModel
import kotlinx.coroutines.flow.Flow

interface GetLessonResourceFromStorageUseCase {
    suspend operator fun invoke(): Flow<List<LessonsModel>>
}