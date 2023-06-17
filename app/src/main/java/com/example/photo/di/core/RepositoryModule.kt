package com.example.photo.di.core

import com.example.photo.data.api.PhotoService
import com.example.photo.data.repository.photo.PhotoRepositoryImpl
import com.example.photo.data.repository.photo.datasource.PhotoCacheDataSource
import com.example.photo.data.repository.photo.datasource.PhotoLocalDataSource
import com.example.photo.data.repository.photo.datasource.PhotoRemoteDataSource
import com.example.photo.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providePhotoRepository(
        photoRemoteDataSource: PhotoRemoteDataSource,
        photoLocalDataSource: PhotoLocalDataSource,
        photoCacheDataSource: PhotoCacheDataSource
    ): PhotoRepository {
        return PhotoRepositoryImpl(
            photoRemoteDataSource,
            photoLocalDataSource,
            photoCacheDataSource
        )
    }

}