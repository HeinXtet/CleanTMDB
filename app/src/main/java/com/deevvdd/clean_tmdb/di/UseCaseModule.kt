package com.deevvdd.clean_tmdb.di

import com.deevvdd.clean_tmdb.domain.usecase.MovieUseCase
import com.deevvdd.clean_tmdb.domain.usecase.MovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindMovieUseCase(
        movieUseImpl: MovieUseCaseImpl
    ): MovieUseCase
}