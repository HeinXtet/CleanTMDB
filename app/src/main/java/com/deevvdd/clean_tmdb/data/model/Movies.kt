package com.deevvdd.clean_tmdb.data.model

data class Movies(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)