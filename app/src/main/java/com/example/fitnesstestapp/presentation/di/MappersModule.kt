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
import com.example.fitnesstestapp.domain.Mapper
import com.example.fitnesstestapp.domain.models.FitnessResponseDomain
import com.example.fitnesstestapp.domain.models.LessonDomain
import com.example.fitnesstestapp.domain.models.TrainerDomain
import com.example.fitnesstestapp.presentation.mappers.base.MapDomainFitnessRespToUi
import com.example.fitnesstestapp.presentation.mappers.lesson.MapDomainLessonListToUi
import com.example.fitnesstestapp.presentation.mappers.lesson.MapDomainLessonToUi
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
    fun provideMapDomainLessonToUi(): Mapper<LessonDomain, LessonUi> = MapDomainLessonToUi()

    @Provides
    fun provideMapDomainLessonListToUi(
        mapper: Mapper<LessonDomain, LessonUi>,
    ): Mapper<List<LessonDomain>, List<LessonUi>> = MapDomainLessonListToUi(mapper = mapper)

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