package com.deevvdd.clean_tmdb.data.repository.datasource

import com.deevvdd.clean_tmdb.data.model.Movies
import retrofit2.Response


interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<Movies>
}