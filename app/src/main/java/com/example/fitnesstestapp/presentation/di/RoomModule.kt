package com.example.fitnesstestapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.fitnesstestapp.data.storage.db.ClubResourceDatabase
import com.example.fitnesstestapp.data.storage.db.FitnessResourcesStorageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideClubResourceDatabase(@ApplicationContext context: Context): ClubResourceDatabase {
        return Room.databaseBuilder(
            context,
            ClubResourceDatabase::class.java,
            ClubResourceDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideFitnessResourcesStorageDao(database: ClubResourceDatabase): FitnessResourcesStorageDao =
        database.clubResponseDao()
}