package com.deevvdd.clean_tmdb.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.deevvdd.clean_tmdb.R
import com.deevvdd.clean_tmdb.databinding.ActivityHomeBinding
import com.deevvdd.clean_tmdb.presentation.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: MovieAdapter
    private val mainViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        initRv()
        mainViewModel.getMovies().observe(this@HomeActivity,
            {
                adapter.setMovies(it ?: emptyList())
                Timber.d("Movies ${it.toString()}")
            })
    }

    private fun initRv() {
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter
    }
}