package com.example.photo.data.repository.photo.datasourceimpl

import com.example.photo.data.db.PhotoDao
import com.example.photo.data.model.photo.Photo
import com.example.photo.data.repository.photo.datasource.PhotoLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoLocalDataSourceImpl(private val photoDao: PhotoDao) : PhotoLocalDataSource {
    override suspend fun getPhotos(): List<Photo> {
        return photoDao.getPhotos()
    }

    override suspend fun savePhotos(data: List<Photo>) {
        CoroutineScope(Dispatchers.IO).launch {
            photoDao.savePhoto(data)
        }
    }

    override suspend fun deleteAllPhoto() {
        CoroutineScope(Dispatchers.IO).launch {
            photoDao.deleteAllPhoto()
        }
    }
}