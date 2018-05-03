package com.itis.android.lessonmvvm.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.itis.android.lessonmvvm.R
import com.itis.android.lessonmvvm.api.service.MovieService
import com.itis.android.lessonmvvm.di.di
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.generic.instance

class MovieListActivity : AppCompatActivity() {

    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movieService: MovieService by di.instance()
        viewModelFactory = ViewModelFactory(movieService)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel::class.java)
        viewModel.getMoviesList()
                ?.observe(this, Observer {
                    if (it?.data != null) {
//                        adapter.setNewValues(it.getData());
                    } else if (it?.error != null) {
                        // show error
                    }
                })
        viewModel.isLoading().observe(this, Observer {
            if (it != null && it) {
                pg_movies.visibility = View.VISIBLE
            } else {
                pg_movies.visibility = View.GONE
            }
        })
    }
}
