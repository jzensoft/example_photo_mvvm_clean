package com.example.photo.di.core

import com.example.photo.data.db.PhotoDao
import com.example.photo.data.repository.photo.datasource.PhotoLocalDataSource
import com.example.photo.data.repository.photo.datasourceimpl.PhotoLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun providePhotoLocalDataSource(photoDao: PhotoDao): PhotoLocalDataSource {
        return PhotoLocalDataSourceImpl(photoDao)
    }

}