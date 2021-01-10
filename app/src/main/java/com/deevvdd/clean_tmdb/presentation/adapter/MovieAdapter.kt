package com.deevvdd.clean_tmdb.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deevvdd.clean_tmdb.data.Config
import com.deevvdd.clean_tmdb.data.model.Movie
import com.deevvdd.clean_tmdb.databinding.ItemMovieBinding
import com.deevvdd.clean_tmdb.presentation.GlideApp


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MVH>() {

    private var movieList = ArrayList<Movie>()


    fun setMovies(movies: List<Movie>) {
        this.movieList = ArrayList(movies)
        notifyDataSetChanged()
    }


    inner class MVH(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Movie) {
            GlideApp.with(
                binding.root.context
            ).load("${Config.IMAGE_PATH}${item.backdrop_path}")
                .into(binding.ivPoster)
            binding.tvMovieName.text = item.original_title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MVH {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MVH(binding)
    }

    override fun onBindViewHolder(holder: MVH, position: Int) {
        holder.onBind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }
}