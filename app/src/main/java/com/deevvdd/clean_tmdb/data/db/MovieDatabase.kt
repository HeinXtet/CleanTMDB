package com.deevvdd.clean_tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deevvdd.clean_tmdb.data.model.Movie


@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}