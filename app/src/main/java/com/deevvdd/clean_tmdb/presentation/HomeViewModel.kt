package com.deevvdd.clean_tmdb.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.deevvdd.clean_tmdb.domain.usecase.MovieUseCase

class HomeViewModel @ViewModelInject constructor(private val movieUseCase: MovieUseCase) :
    ViewModel() {

    fun getMovies() = liveData {
        val movieList = movieUseCase.getMovies()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = movieUseCase.updateMovie()
        emit(movieList)
    }
}