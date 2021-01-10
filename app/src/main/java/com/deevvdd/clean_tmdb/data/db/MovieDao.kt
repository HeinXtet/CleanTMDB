package com.deevvdd.clean_tmdb.data.db

import androidx.room.*
import com.deevvdd.clean_tmdb.data.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movie")
    suspend fun deleteAllPopularMovie()

    @Query("SELECT * FROM popular_movie")
    suspend fun getAllPopularMovie(): List<Movie>


}