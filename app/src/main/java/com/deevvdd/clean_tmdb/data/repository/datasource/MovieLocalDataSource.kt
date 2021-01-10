package com.deevvdd.clean_tmdb.data.repository.datasource

import com.deevvdd.clean_tmdb.data.model.Movie


interface MovieLocalDataSource{
    suspend fun getMovieFromDB () : List<Movie>
    suspend fun saveMovesToDB (movies : List<Movie>)
    suspend fun clearAll()
}