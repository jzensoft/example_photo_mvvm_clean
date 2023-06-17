package com.example.photo.data.repository.photo.datasource

import com.example.photo.data.model.photo.Photo

interface PhotoLocalDataSource {
    suspend fun getPhotos(): List<Photo>
    suspend fun savePhotos(data: List<Photo>)
    suspend fun deleteAllPhoto()
}