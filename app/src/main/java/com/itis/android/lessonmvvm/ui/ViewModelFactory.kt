package com.itis.android.lessonmvvm.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.itis.android.lessonmvvm.api.service.MovieService

/**
 * Created by Nail Shaykhraziev on 03.05.2018.
 */
class ViewModelFactory(private val movieService: MovieService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            when {
                modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                    MovieViewModel(movieService) as? T
                            ?: throw IllegalArgumentException("Unknown ViewModel class")
                }
                else -> {
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
}