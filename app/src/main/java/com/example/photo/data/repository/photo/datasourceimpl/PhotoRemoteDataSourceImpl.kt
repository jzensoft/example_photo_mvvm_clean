package com.example.photo.data.repository.photo.datasourceimpl

import com.example.photo.data.api.PhotoService
import com.example.photo.data.model.photo.PhotoResult
import com.example.photo.data.repository.photo.datasource.PhotoRemoteDataSource
import retrofit2.Response

class PhotoRemoteDataSourceImpl(private val photoService: PhotoService) : PhotoRemoteDataSource {
    override suspend fun getPhotos(): Response<PhotoResult> {
        return photoService.getPhoto()
    }
}