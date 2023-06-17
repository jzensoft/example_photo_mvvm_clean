package com.example.photo.data.model.photo


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photo")
data class Photo(
    @PrimaryKey
    @SerializedName("albumId")
    val albumId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String
)