package com.example.fitnesstestapp.data.storage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fitnesstestapp.data.storage.db.converters.LessonsConverter
import com.example.fitnesstestapp.data.storage.db.converters.TrainersConverter
import com.example.fitnesstestapp.data.storage.model.FitnessResourcesStorage

@Database(entities = [FitnessResourcesStorage::class], version = 1)
@TypeConverters(LessonsConverter::class, TrainersConverter::class)
abstract class ClubResourceDatabase : RoomDatabase() {

    abstract fun clubResponseDao(): FitnessResourcesStorageDao

    companion object {
        const val DATABASE_NAME = "CLUB_DATABASE_NAME"
    }
}