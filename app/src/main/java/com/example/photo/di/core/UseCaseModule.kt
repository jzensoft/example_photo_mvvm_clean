package com.example.photo.di.core

import com.example.photo.domain.repository.PhotoRepository
import com.example.photo.domain.usecase.GetPhotoUseCase
import com.example.photo.domain.usecase.UpdatePhotoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetPhotoUseCase(repository: PhotoRepository): GetPhotoUseCase {
        return GetPhotoUseCase(repository)
    }

    @Provides
    fun provideUpdatePhotoUseCase(repository: PhotoRepository): UpdatePhotoUseCase {
        return UpdatePhotoUseCase(repository)
    }

}