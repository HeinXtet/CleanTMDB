package com.deevvdd.clean_tmdb.data.repository.datasourceImpl

import com.deevvdd.clean_tmdb.data.db.MovieDao
import com.deevvdd.clean_tmdb.data.model.Movie
import com.deevvdd.clean_tmdb.data.repository.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMovieFromDB(): List<Movie> {
        return movieDao.getAllPopularMovie()
    }

    override suspend fun saveMovesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllPopularMovie()
        }
    }

}