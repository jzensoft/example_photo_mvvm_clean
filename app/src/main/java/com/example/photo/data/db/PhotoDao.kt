package com.example.photo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.photo.data.model.photo.Photo

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePhoto(data: List<Photo>)

    @Query("SELECT * FROM photo")
    suspend fun getPhotos(): List<Photo>

    @Query("DELETE FROM photo")
    suspend fun deleteAllPhoto()
}