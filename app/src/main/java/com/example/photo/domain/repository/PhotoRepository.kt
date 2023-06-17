package com.example.photo.domain.repository

import com.example.photo.data.model.photo.Photo

interface PhotoRepository {
    suspend fun getPhotos(): List<Photo>
    suspend fun updatePhotos(): List<Photo>
}