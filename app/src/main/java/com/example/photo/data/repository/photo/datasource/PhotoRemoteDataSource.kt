package com.example.photo.data.repository.photo.datasource

import com.example.photo.data.model.photo.PhotoResult
import retrofit2.Response

interface PhotoRemoteDataSource {
    suspend fun getPhotos(): Response<PhotoResult>
}