package com.example.fitnesstestapp.data.storage.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fitnesstestapp.data.storage.model.FitnessResourcesStorage

@Dao
interface FitnessResourcesStorageDao {

    @Insert()
    suspend fun saveToStorage(resource: FitnessResourcesStorage)

    @Query("SELECT * FROM CLUB_RESOURCES_TABLE_NAME")
    suspend fun getAllClubResourcesFromCache(): FitnessResourcesStorage

    @Query("DELETE FROM CLUB_RESOURCES_TABLE_NAME")
    suspend fun clearCache()
}