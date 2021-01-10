package com.deevvdd.clean_tmdb.domain.usecase

import com.deevvdd.clean_tmdb.data.model.Movie
import com.deevvdd.clean_tmdb.domain.repository.MovieRepository
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(private val movieRepository: MovieRepository) :
    MovieUseCase {
    override suspend fun getMovies(): List<Movie>? {
        return movieRepository.getMovies()
    }

    override suspend fun updateMovie(): List<Movie>? {
        return movieRepository.updateMovies()
    }
}