package com.deevvdd.clean_tmdb.data.repository.repositoryImpl

import android.util.Log
import com.deevvdd.clean_tmdb.data.model.Movie
import com.deevvdd.clean_tmdb.data.repository.datasource.MovieCacheDataSource
import com.deevvdd.clean_tmdb.data.repository.datasource.MovieLocalDataSource
import com.deevvdd.clean_tmdb.data.repository.datasource.MovieRemoteDataSource
import com.deevvdd.clean_tmdb.domain.repository.MovieRepository
import timber.log.Timber
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newMovieList = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovesToDB(newMovieList)
        movieCacheDataSource.saveMovesToCache(newMovieList)
        return newMovieList
    }


    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.results
            }
        } catch (e: Exception) {
            Log.d("Movie Error", e.message)
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMovieFromDB()

        } catch (e: Exception) {
            Timber.d("Movie Error $e")
        }

        if (movieList.isEmpty()) {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMovesToDB(movieList)
        } else {
            return movieList
        }

        return movieList
    }


    suspend fun getMovieFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Timber.d("Movie Error $e")
        }
        if (movieList.isEmpty()) {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovesToCache(movieList)
        } else {
            return movieList
        }
        return movieList
    }

}