package com.deevvdd.clean_tmdb.di

import com.deevvdd.clean_tmdb.data.repository.datasource.MovieCacheDataSource
import com.deevvdd.clean_tmdb.data.repository.datasource.MovieLocalDataSource
import com.deevvdd.clean_tmdb.data.repository.datasource.MovieRemoteDataSource
import com.deevvdd.clean_tmdb.data.repository.datasourceImpl.MovieCacheDataSourceImpl
import com.deevvdd.clean_tmdb.data.repository.datasourceImpl.MovieLocalDataSourceImpl
import com.deevvdd.clean_tmdb.data.repository.datasourceImpl.MovieRemoteDataSourceImpl
import com.deevvdd.clean_tmdb.data.repository.repositoryImpl.MovieRepositoryImpl
import com.deevvdd.clean_tmdb.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRemoteDataSource(
        movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl
    ): MovieRemoteDataSource

    @Binds
    abstract fun bindMovieLocalDataSource(
        movieLocalDataSourceImpl: MovieLocalDataSourceImpl
    ): MovieLocalDataSource

    @Binds
    abstract fun bindMovieCacheDataSource(
        movieCacheDataSourceImpl: MovieCacheDataSourceImpl
    ): MovieCacheDataSource

    @Binds
    abstract fun bindMovieRepository(
        repositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}