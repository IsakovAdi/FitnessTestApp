package com.example.fitnesstestapp.data.storage.model

import androidx.room.*
import com.example.fitnesstestapp.data.storage.db.converters.LessonsConverter
import com.example.fitnesstestapp.data.storage.db.converters.TrainersConverter
import com.example.fitnesstestapp.data.storage.model.FitnessResourcesStorage.Companion.CLUB_RESOURCES_TABLE_NAME
import java.util.Date


@Entity(tableName = CLUB_RESOURCES_TABLE_NAME)
class FitnessResourcesStorage(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @TypeConverters(LessonsConverter::class, TrainersConverter::class)
    @ColumnInfo(name = "lessons") val lessons: List<LessonStorage>,
    @ColumnInfo(name = "trainers") val trainers: List<TrainerStorage>,
    @ColumnInfo(name = "saved_date") val savedDate: String
) {
    companion object {
        const val CLUB_RESOURCES_TABLE_NAME = "club_resources_table_name"
    }
}