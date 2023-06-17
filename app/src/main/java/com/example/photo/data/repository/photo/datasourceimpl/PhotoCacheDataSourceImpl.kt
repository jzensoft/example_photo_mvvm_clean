package com.example.photo.data.repository.photo.datasourceimpl

import com.example.photo.data.model.photo.Photo
import com.example.photo.data.repository.photo.datasource.PhotoCacheDataSource

class PhotoCacheDataSourceImpl : PhotoCacheDataSource {
    private val photos = mutableListOf<Photo>()
    override suspend fun getPhotos(): List<Photo> {
        return photos
    }

    override suspend fun savePhotos(data: List<Photo>) {
        photos.clear()
        photos.addAll(data)
    }
}