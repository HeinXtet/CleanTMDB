package com.deevvdd.clean_tmdb.domain.usecase

import com.deevvdd.clean_tmdb.data.model.Movie

interface MovieUseCase {
    suspend fun getMovies()  : List<Movie>?
    suspend fun updateMovie() :List<Movie>?
}