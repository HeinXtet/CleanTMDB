package com.deevvdd.clean_tmdb.data.network

import com.deevvdd.clean_tmdb.data.model.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Response<Movies>
}