package com.example.fitnesstestapp.domain.interactors

import android.annotation.SuppressLint
import com.example.fitnesstestapp.domain.DataRequestState
import com.example.fitnesstestapp.domain.UNIX_START_DATE
import com.example.fitnesstestapp.domain.formatISOAsDate
import com.example.fitnesstestapp.domain.helpers.DispatchersProvider
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.domain.models.TrainerDomain
import com.example.fitnesstestapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.text.SimpleDateFormat
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

        val dateList = lessons.map { it.date.formatISOAsDate() }.toSet()

        val allLessons = mutableListOf<LessonsModel>()

        dateList.forEach { currentDate ->
            allLessons.add(LessonsModel.LessonDate(currentDate.toString()))
            lessons.forEach { lessonDomain ->
                if (lessonDomain.date.formatISOAsDate() == currentDate) {
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

/* Из модельки занятий Domain преобразовываем в необходимую для нас модельку для отображения в ui */

    private fun mapLessonDomainToLessonModel(
        lessonDomain: LessonDomain, trainers: List<TrainerDomain>,
    ) = lessonDomain.run {
        LessonsModel.Lesson(
            lessonName = lessonName,
            startTime = startTime,
            endTime = endTime,
            availableSlots = availableSlots,
            coachName = getTrainerName(coachId = coachId, trainers = trainers),
            place = place,
            color = color,
            category = category,
            duration = formatDuration(startTime, endTime)
        )
    }

    /*Из времени начало занятий и конца занятий парсим продолжительность*/

    @SuppressLint("SimpleDateFormat")
    fun formatDuration(start: String, end: String): String {
        val format = SimpleDateFormat("HH:mm")
        val startTime = format.parse(start)
        val endTime = format.parse(end)
//        val duration = (endTime!!.time - startTime!!.time)/60000
        val duration = ((endTime?.time ?: UNIX_START_DATE.time) - (startTime?.time
            ?: UNIX_START_DATE.time)) / 60000
        return timeFormat(duration.toInt())
    }

    /*Из продолжительности занятий в минутах парсим в необходимый для нас формат*/
    private fun timeFormat(minutes: Int): String {
        val hours = (minutes / 60)
        val mins = (minutes % 60)
        return if (hours > 0 && mins > 0) {
            String.format("%2dч. %02dмин.", hours, mins)
        } else if (hours == 0) {
            String.format("%02dмин.", mins)
        } else if (mins == 0) {
            String.format("%2dч.", hours, mins)
        } else "No value"

    }

    /* Из коллекций тренеров получаем имя тренера для занятия по идентификатору */
    private fun getTrainerName(coachId: String, trainers: List<TrainerDomain>) = trainers.filter {
        it.trainerId.equals(coachId)
    }.map {
        it.trainerName
    }.firstOrNull() ?: ""
}


