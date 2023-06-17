package com.example.photo.di.core

import com.example.photo.data.repository.photo.datasource.PhotoCacheDataSource
import com.example.photo.data.repository.photo.datasourceimpl.PhotoCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataSourceModule {

    @Singleton
    @Provides
    fun providePhotoCacheDataSource(): PhotoCacheDataSource {
        return PhotoCacheDataSourceImpl()
    }

}