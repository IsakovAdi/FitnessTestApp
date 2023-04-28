package com.example.fitnesstestapp.domain.interactors

import com.example.fitnesstestapp.domain.models.LessonsModel
import kotlinx.coroutines.flow.Flow


interface GetLessonsUseCase {
    operator fun invoke(clubId: Int): Flow<List<LessonsModel>>

}
