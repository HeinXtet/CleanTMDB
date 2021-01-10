package com.deevvdd.clean_tmdb.data.repository.datasourceImpl

import com.deevvdd.clean_tmdb.data.Config
import com.deevvdd.clean_tmdb.data.model.Movies
import com.deevvdd.clean_tmdb.data.network.ApiService
import com.deevvdd.clean_tmdb.data.repository.datasource.MovieRemoteDataSource
import retrofit2.Response
import javax.inject.Inject


class MovieRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<Movies> =
        apiService.getPopularMovies(Config.API_KEY, 1)
}