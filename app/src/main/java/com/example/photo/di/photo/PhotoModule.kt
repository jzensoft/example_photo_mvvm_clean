package com.example.photo.di.photo

import com.example.photo.domain.usecase.GetPhotoUseCase
import com.example.photo.domain.usecase.UpdatePhotoUseCase
import com.example.photo.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class PhotoModule {

    @ActivityScoped
    @Provides
    fun provideMainViewModelFactory(
        getPhotoUseCase: GetPhotoUseCase,
        updatePhotoUseCase: UpdatePhotoUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getPhotoUseCase, updatePhotoUseCase)
    }

}