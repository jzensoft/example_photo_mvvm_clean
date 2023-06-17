package com.example.photo.domain.usecase

import com.example.photo.data.model.photo.Photo
import com.example.photo.domain.repository.PhotoRepository

class UpdatePhotoUseCase(private val repository: PhotoRepository) {
    suspend fun execute(): List<Photo> = repository.updatePhotos()
}