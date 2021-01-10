package com.deevvdd.clean_tmdb.data.repository.datasourceImpl

import com.deevvdd.clean_tmdb.data.model.Movie
import com.deevvdd.clean_tmdb.data.repository.datasource.MovieCacheDataSource
import javax.inject.Inject


class MovieCacheDataSourceImpl @Inject constructor() : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

}