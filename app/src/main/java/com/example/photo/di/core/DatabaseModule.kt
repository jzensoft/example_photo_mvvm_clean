package com.example.photo.di.core

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.photo.data.db.PhotoDao
import com.example.photo.data.db.PhotoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providePhotoDatabase(application: Application): PhotoDatabase {
        return Room.databaseBuilder(application, PhotoDatabase::class.java, "photo")
            .build()
    }

    @Singleton
    @Provides
    fun providePhotoDao(photoDatabase: PhotoDatabase): PhotoDao {
        return photoDatabase.photoDao()
    }

}