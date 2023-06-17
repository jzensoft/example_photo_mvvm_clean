package com.example.photo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photo.data.model.photo.Photo

@Database(
    entities = [Photo::class],
    exportSchema = false,
    version = 1
)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}