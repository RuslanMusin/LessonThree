package com.itis.android.lessonmvvm.ui.movielist

import android.support.annotation.ColorInt
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.itis.android.lessonmvvm.R
import com.itis.android.lessonmvvm.model.api_response.movie.Movie
import com.itis.android.lessonmvvm.utils.POSTER_SIZE_MEDIUM
import com.itis.android.lessonmvvm.utils.loadPicture
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by Nail Shaykhraziev on 06.05.2018.
 */
class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie, onClickListener: (Pair<Movie, View>) -> Unit) {
        itemView.setOnClickListener { onClickListener(Pair(movie, itemView.iv_cover)) }
        itemView.tv_name.text = movie.title
        itemView.tv_description.text = movie.overview
        itemView.tv_rating.text = movie.voteAverage?.times(10)?.toInt().toString()
        movie.voteAverage?.let {
            @ColorInt val colorInt = when {
                it >= 7.0 -> {
                    R.color.accent
                }
                it >= 4.5 -> {
                    R.color.yellow
                }
                else -> {
                    R.color.red
                }
            }
            itemView.tv_rating.setTextColor(ContextCompat.getColor(itemView.context, colorInt))
        }
        itemView.tv_release_date.text = movie.releaseDate
        loadPicture(itemView.iv_cover, movie.posterPath, POSTER_SIZE_MEDIUM)
    }
}
