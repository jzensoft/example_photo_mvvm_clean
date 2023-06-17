package com.example.photo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photo.data.model.photo.Photo
import com.example.photo.domain.usecase.GetPhotoUseCase
import com.example.photo.domain.usecase.UpdatePhotoUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPhotoUseCase: GetPhotoUseCase,
    private val updatePhotoUseCase: UpdatePhotoUseCase
) : ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    fun getPhotos() {
        viewModelScope.launch {
            val data = getPhotoUseCase.execute()
            _photos.value = data
        }
    }

    fun updatePhotos() {
        viewModelScope.launch {
            val data = updatePhotoUseCase.execute()
            _photos.value = data
        }
    }

}