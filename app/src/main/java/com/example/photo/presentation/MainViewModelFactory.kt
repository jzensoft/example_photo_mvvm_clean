package com.example.photo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.photo.domain.usecase.GetPhotoUseCase
import com.example.photo.domain.usecase.UpdatePhotoUseCase

class MainViewModelFactory(
    private val getPhotoUseCase: GetPhotoUseCase,
    private val updatePhotoUseCase: UpdatePhotoUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getPhotoUseCase, updatePhotoUseCase) as T
    }
}