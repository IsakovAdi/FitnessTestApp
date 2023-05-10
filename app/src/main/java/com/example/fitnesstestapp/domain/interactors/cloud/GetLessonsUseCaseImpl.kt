package com.example.fitnesstestapp.domain.interactors.cloud

import android.annotation.SuppressLint
import com.example.fitnesstestapp.domain.DataRequestState
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import com.example.fitnesstestapp.domain.helpers.formatDuration
import com.example.fitnesstestapp.domain.helpers.mapLessonDomainToLessonModel
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.domain.models.TrainerDomain
import com.example.fitnesstestapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class GetLessonsUseCaseImpl @Inject constructor(
    private val repository: Repository,
    private val dispatchersProvider: DispatchersProvider,
) : GetLessonsUseCase {
    override fun invoke(clubId: Int): Flow<List<LessonsModel>> = flow {
        val response = repository.getLessons(clubId = clubId)
        val lessons = when (response) {
            is DataRequestState.Success -> response.data.lessons
            is DataRequestState.Error -> emptyList()
        }
        val trainers = when (response) {
            is DataRequestState.Success -> response.data.trainers
            is DataRequestState.Error -> emptyList()
        }

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


