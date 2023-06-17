package com.example.photo.data.api

import com.example.photo.data.model.photo.PhotoResult
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    suspend fun getPhoto(): Response<PhotoResult>

}