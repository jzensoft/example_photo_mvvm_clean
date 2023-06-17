package com.example.photo.data.repository.photo

import android.util.Log
import com.example.photo.data.model.photo.Photo
import com.example.photo.data.repository.photo.datasource.PhotoCacheDataSource
import com.example.photo.data.repository.photo.datasource.PhotoLocalDataSource
import com.example.photo.data.repository.photo.datasource.PhotoRemoteDataSource
import com.example.photo.domain.repository.PhotoRepository
import com.google.gson.Gson

class PhotoRepositoryImpl(
    private val photoService: PhotoRemoteDataSource,
    private val photoLocalDataSource: PhotoLocalDataSource,
    private val photoCacheDataSource: PhotoCacheDataSource
) : PhotoRepository {

    private val TAG = PhotoRepositoryImpl::class.simpleName

    override suspend fun getPhotos(): List<Photo> {
        return getPhotoFromCache()
    }

    override suspend fun updatePhotos(): List<Photo> {
        val newPhoto = getPhotoFromService()
        photoLocalDataSource.deleteAllPhoto()
        photoLocalDataSource.savePhotos(newPhoto)
        photoCacheDataSource.savePhotos(newPhoto)
        return newPhoto
    }

    private suspend fun getPhotoFromService(): List<Photo> {
        val data = mutableListOf<Photo>()
        try {
            val res = photoService.getPhotos()
            val body = res.body()
            body?.let {
                data.addAll(it)
            }
        } catch (e: Exception) {
            Log.e(TAG, e.message ?: "")
        }
        Log.wtf(TAG, Gson().toJson(data))
        return data
    }

    private suspend fun getPhotoFromLocal(): List<Photo> {
        val data = mutableListOf<Photo>()
        try {
            val res = photoLocalDataSource.getPhotos()
            data.addAll(res)
        } catch (e: Exception) {
            Log.e(TAG, e.message ?: "")
        }
        if (data.isEmpty()) {
            data.addAll(getPhotoFromService())
            photoLocalDataSource.savePhotos(data)
        }
        return data
    }

    private suspend fun getPhotoFromCache(): List<Photo> {
        val data = mutableListOf<Photo>()
        try {
            data.addAll(photoCacheDataSource.getPhotos())
        } catch (e: Exception) {
            Log.e(TAG, e.message ?: "")
        }
        if (data.isEmpty()) {
            data.addAll(getPhotoFromLocal())
            photoCacheDataSource.savePhotos(data)
        }
        return data
    }
}