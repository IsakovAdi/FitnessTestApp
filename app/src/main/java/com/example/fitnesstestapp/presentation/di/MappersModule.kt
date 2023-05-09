package com.example.fitnesstestapp.presentation.di

import com.example.fitnesstestapp.data.cloud.mappers.base.MapFitnessRespToData
import com.example.fitnesstestapp.data.cloud.mappers.lesson.MapLessonListToData
import com.example.fitnesstestapp.data.cloud.mappers.lesson.MapLessonToData
import com.example.fitnesstestapp.data.cloud.mappers.trainer.MapCloudTrainerListToData
import com.example.fitnesstestapp.data.cloud.mappers.trainer.MapCloudTrainerToData
import com.example.fitnesstestapp.data.cloud.models.FitnessResponseCloud
import com.example.fitnesstestapp.data.cloud.models.LessonCloud
import com.example.fitnesstestapp.data.cloud.models.TrainerCloud
import com.example.fitnesstestapp.data.mappers.base.MapDataFitnessRespToDomain
import com.example.fitnesstestapp.data.mappers.lesson.MapDataLessonListToDomain
import com.example.fitnesstestapp.data.mappers.lesson.MapDataLessonToDomain
import com.example.fitnesstestapp.data.mappers.trainer.MapDataTrainerListToDomain
import com.example.fitnesstestapp.data.mappers.trainer.MapDataTrainerToDomain
import com.example.fitnesstestapp.data.models.FitnessResponseData
import com.example.fitnesstestapp.data.models.LessonData
import com.example.fitnesstestapp.data.models.TrainerData
import com.example.fitnesstestapp.data.storage.mappers.base.MapDataResponseToStorage
import com.example.fitnesstestapp.data.storage.mappers.base.MapStorageResponseToData
import com.example.fitnesstestapp.data.storage.mappers.lesson.MapDataLessonListToStorage
import com.example.fitnesstestapp.data.storage.mappers.lesson.MapDataLessonToStorage
import com.example.fitnesstestapp.data.storage.mappers.lesson.MapStorageLessonListToData
import com.example.fitnesstestapp.data.storage.mappers.lesson.MapStorageLessonToData
import com.example.fitnesstestapp.data.storage.mappers.trainer.MapDataTrainerListToData
import com.example.fitnesstestapp.data.storage.mappers.trainer.MapDataTrainerToStorage
import com.example.fitnesstestapp.data.storage.mappers.trainer.MapStorageTrainerListToData
import com.example.fitnesstestapp.data.storage.mappers.trainer.MapStorageTrainerToData
import com.example.fitnesstestapp.data.storage.model.FitnessResourcesStorage
import com.example.fitnesstestapp.data.storage.model.LessonStorage
import com.example.fitnesstestapp.data.storage.model.TrainerStorage
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.domain.models.LessonsModel
import com.example.fitnesstestapp.domain.models.TrainerDomain
import com.example.fitnesstestapp.presentation.mappers.base.MapDomainFitnessRespToUi
import com.example.fitnesstestapp.presentation.mappers.lesson.MapDomainLessonModelToUiLesson
import com.example.fitnesstestapp.presentation.mappers.lesson.MapDomainLessonToUiLesson
import com.example.fitnesstestapp.presentation.mappers.lesson.MapDomainLessonsModelListToUiLessonList
import com.example.fitnesstestapp.presentation.mappers.trainer.MapDomainTrainerListToUi
import com.example.fitnesstestapp.presentation.mappers.trainer.MapDomainTrainerToUi
import com.example.fitnesstestapp.presentation.models.FitnessResponseUi
import com.example.fitnesstestapp.presentation.models.LessonUi
import com.example.fitnesstestapp.presentation.models.TrainerUi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MappersModule {
    // storage
    @Provides
    fun provideMapDataResponseToStorage(
        lessonMapper: Mapper<List<LessonData>, List<LessonStorage>>,
        trainerMapper: Mapper<List<TrainerData>, List<TrainerStorage>>,
    ): Mapper<FitnessResponseData, FitnessResourcesStorage> =
        MapDataResponseToStorage(lessonMapper = lessonMapper, trainerMapper = trainerMapper)

    @Provides
    fun provideMapStorageResponseToData(
        lessonMapper: Mapper<List<LessonStorage>, List<LessonData>>,
        trainerMapper: Mapper<List<TrainerStorage>, List<TrainerData>>,
    ): Mapper<FitnessResourcesStorage, FitnessResponseData> =
        MapStorageResponseToData(lessonMapper = lessonMapper, trainerMapper = trainerMapper)

    @Provides
    fun provideMapDataLessonListToStorage(
        mapper: Mapper<LessonData, LessonStorage>,
    ): Mapper<List<LessonData>, List<LessonStorage>> = MapDataLessonListToStorage(mapper = mapper)

    @Provides
    fun provideMapDataLessonToStorage(): Mapper<LessonData, LessonStorage> =
        MapDataLessonToStorage()

    @Provides
    fun provideMapStorageLessonListToData(
        mapper: Mapper<LessonStorage, LessonData>,
    ): Mapper<List<LessonStorage>, List<LessonData>> = MapStorageLessonListToData(mapper = mapper)

    @Provides
    fun provideMapStorageLessonToData(): Mapper<LessonStorage, LessonData> =
        MapStorageLessonToData()

    @Provides
    fun provideMapDataTrainerListToData(
        mapper: Mapper<TrainerData, TrainerStorage>,
    ): Mapper<List<TrainerData>, List<TrainerStorage>> = MapDataTrainerListToData(mapper = mapper)

    @Provides
    fun provideMapDataTrainerToStorage(): Mapper<TrainerData, TrainerStorage> =
        MapDataTrainerToStorage()

    @Provides
    fun provideMapStorageTrainerListToData(
        mapper: Mapper<TrainerStorage, TrainerData>,
    ): Mapper<List<TrainerStorage>, List<TrainerData>> =
        MapStorageTrainerListToData(mapper = mapper)

    @Provides
    fun provideMapStorageTrainerToData(): Mapper<TrainerStorage, TrainerData> =
        MapStorageTrainerToData()

    // cloud
    @Provides
    fun provideMapLessonToData(): Mapper<LessonCloud, LessonData> = MapLessonToData()

    @Provides
    fun provideMapLessonListToData(
        mapper: Mapper<LessonCloud, LessonData>,
    ): Mapper<List<LessonCloud>, List<LessonData>> = MapLessonListToData(mapper = mapper)

    @Provides
    fun provideMapCloudTrainerToData(): Mapper<TrainerCloud, TrainerData> = MapCloudTrainerToData()

    @Provides
    fun provideMapCloudTrainerListToData(
        mapper: Mapper<TrainerCloud, TrainerData>,
    ): Mapper<List<TrainerCloud>, List<TrainerData>> = MapCloudTrainerListToData(mapper = mapper)

    @Provides
    fun provideMapFitnessRespToData(
        lessonMapper: Mapper<List<LessonCloud>, List<LessonData>>,
        trainerMapper: Mapper<List<TrainerCloud>, List<TrainerData>>,
    ): Mapper<FitnessResponseCloud, FitnessResponseData> =
        MapFitnessRespToData(lessonMapper = lessonMapper, trainerMapper = trainerMapper)

    // data
    @Provides
    fun provideMapDataLessonToDomain(): Mapper<LessonData, LessonDomain> = MapDataLessonToDomain()

    @Provides
    fun provideMapDataLessonListToDomain(
        mapper: Mapper<LessonData, LessonDomain>,
    ): Mapper<List<LessonData>, List<LessonDomain>> = MapDataLessonListToDomain(mapper = mapper)

    @Provides
    fun provideMapDataTrainerToDomain(): Mapper<TrainerData, TrainerDomain> =
        MapDataTrainerToDomain()

    @Provides
    fun provideMapDataTrainerListToDomain(
        mapper: Mapper<TrainerData, TrainerDomain>,
    ): Mapper<List<TrainerData>, List<TrainerDomain>> = MapDataTrainerListToDomain(mapper = mapper)

    @Provides
    fun provideMapDataFitnessRespToDomain(
        lessonMapper: Mapper<List<LessonData>, List<LessonDomain>>,
        trainerMapper: Mapper<List<TrainerData>, List<TrainerDomain>>,
    ): Mapper<FitnessResponseData, FitnessResponseDomain> = MapDataFitnessRespToDomain(
        lessonMapper = lessonMapper,
        trainerMapper = trainerMapper
    )

    // presentation
    @Provides
    fun provideMapDomainLessonToUiLesson(
        mapper: Mapper<TrainerDomain, TrainerUi>,
    ): Mapper<LessonsModel.Lesson, LessonUi.Lesson> = MapDomainLessonToUiLesson(mapper = mapper)

    @Provides
    fun provideMapDomainLessonsModelListToUiLessonList(
        mapper: Mapper<LessonsModel, LessonUi>,
    ): Mapper<List<LessonsModel>, List<LessonUi>> =
        MapDomainLessonsModelListToUiLessonList(mapper = mapper)

    @Provides
    fun provideMapDomainLessonModelToUiLesson(
        mapper: Mapper<LessonsModel.Lesson, LessonUi.Lesson>,
    ): Mapper<LessonsModel, LessonUi> = MapDomainLessonModelToUiLesson(mapper = mapper)


    @Provides
    fun provideMapDomainTrainerToUi(): Mapper<TrainerDomain, TrainerUi> = MapDomainTrainerToUi()

    @Provides
    fun provideMapDomainTrainerListToUi(
        mapper: Mapper<TrainerDomain, TrainerUi>,
    ): Mapper<List<TrainerDomain>, List<TrainerUi>> = MapDomainTrainerListToUi(mapper = mapper)

    @Provides
    fun provideMapDomainFitnessRespToUi(
        lessonMapper: Mapper<List<LessonDomain>, List<LessonUi>>,
        trainerMapper: Mapper<List<TrainerDomain>, List<TrainerUi>>,
    ): Mapper<FitnessResponseDomain, FitnessResponseUi> =
        MapDomainFitnessRespToUi(lessonMapper = lessonMapper, trainerMapper = trainerMapper)

}