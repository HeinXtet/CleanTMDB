package com.deevvdd.clean_tmdb.domain.repository

import com.deevvdd.clean_tmdb.data.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies () : List<Movie>?
}