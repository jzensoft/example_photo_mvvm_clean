package com.example.photo.data.repository.photo.datasource

import com.example.photo.data.model.photo.Photo

interface PhotoCacheDataSource {
    suspend fun getPhotos(): List<Photo>
    suspend fun savePhotos(data: List<Photo>)
}