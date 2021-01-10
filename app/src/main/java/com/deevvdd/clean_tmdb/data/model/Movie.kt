package com.deevvdd.clean_tmdb.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movie")
data class Movie(
    @PrimaryKey
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val backdrop_path: String,
    val title: String,
    val video: Boolean,
)