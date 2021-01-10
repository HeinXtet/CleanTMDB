package com.deevvdd.clean_tmdb.data.repository.datasource

import com.deevvdd.clean_tmdb.data.model.Movie


interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMovesToCache(movies: List<Movie>)
}