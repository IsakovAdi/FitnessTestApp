package com.example.fitnesstestapp.domain.interactors.sotorage

import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import com.example.fitnesstestapp.domain.helpers.mapLessonDomainToLessonModel
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.domain.repository.StorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetLessonResourceFromStorageUseCaseImpl @Inject constructor(
    private val repository: StorageRepository,
    private val dispatchersProvider: DispatchersProvider,
) : GetLessonResourceFromStorageUseCase {
    override suspend fun invoke(): Flow<List<LessonsModel>> = flow {
        val resource = repository.getResourcesFromStorage()
        val lessons = resource?.lessons ?: emptyList()
        val trainers = resource?.trainers ?: emptyList()

        val dateList = lessons.map {
            it.date
        }.toSortedSet()

        val allLessons = mutableListOf<LessonsModel>()
        dateList.forEach { currentDate ->
            allLessons.add(LessonsModel.LessonDate(currentDate.toString()))
            lessons.forEach { lessonDomain ->
                if (lessonDomain.date == currentDate) {
                    allLessons.add(
                        mapLessonDomainToLessonModel(
                            lessonDomain = lessonDomain,
                            trainers = trainers
                        )
                    )
                }
            }
        }
        emit(allLessons)
    }.flowOn(dispatchersProvider.default())
}