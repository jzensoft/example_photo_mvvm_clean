package com.example.photo.di.core

import com.example.photo.data.api.PhotoService
import com.example.photo.data.repository.photo.datasource.PhotoRemoteDataSource
import com.example.photo.data.repository.photo.datasourceimpl.PhotoRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Singleton
    @Provides
    fun providePhotoRemoteDataSource(photoService: PhotoService): PhotoRemoteDataSource {
        return PhotoRemoteDataSourceImpl(photoService)
    }

}