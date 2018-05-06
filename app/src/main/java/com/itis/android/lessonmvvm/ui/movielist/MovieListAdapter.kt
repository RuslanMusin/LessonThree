package com.itis.android.lessonmvvm.ui.movielist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itis.android.lessonmvvm.R
import com.itis.android.lessonmvvm.model.api_response.movie.Movie

class MovieListAdapter(private var movieList: List<Movie>,
                       private val movieClickListener: ((Pair<Movie, View>)) -> Unit)
    : RecyclerView.Adapter<MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,
                parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList[position], movieClickListener)
    }

    fun updateData(updateList: List<Movie>) {
        this.movieList = updateList
        notifyDataSetChanged()
    }
}
