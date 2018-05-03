package com.itis.android.lessonmvvm.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.MainThread
import com.itis.android.lessonmvvm.api.service.MovieService
import com.itis.android.lessonmvvm.model.Response
import com.itis.android.lessonmvvm.model.movie.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


/**
 * Created by Nail Shaykhraziev on 29.04.2018.
 */
class MovieViewModel(private val movieService: MovieService) : ViewModel() {

    private val loadingLiveData = MutableLiveData<Boolean>()

    private var moviesLiveData: MutableLiveData<Response<List<Movie>>>? = null

    fun isLoading(): LiveData<Boolean> {
        return loadingLiveData
    }

    @MainThread
    fun getMoviesList(): LiveData<Response<List<Movie>>>? {
        if (moviesLiveData == null) {
            moviesLiveData = MutableLiveData()
            movieService.topRatedMovies()
                    .map { it.movies }
//                    .map({
//                        it.sortedBy { it.voteAverage }
//                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { loadingLiveData.setValue(true) }
                    .doAfterTerminate { loadingLiveData.setValue(false) }
                    .subscribeBy(onSuccess = {
                        val moviesLiveDataImm = moviesLiveData
                        moviesLiveDataImm?.value = Response.success(it)
                    }, onError = {
                        val moviesLiveDataImm = moviesLiveData
                        moviesLiveDataImm?.setValue(Response.error(it))
                    })
        }
        return moviesLiveData
    }
}
