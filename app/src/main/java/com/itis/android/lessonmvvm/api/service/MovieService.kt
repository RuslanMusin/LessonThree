package com.itis.android.lessonmvvm.api.service

import com.itis.android.lessonmvvm.model.Genre
import com.itis.android.lessonmvvm.model.MoviesResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Nail Shaykhraziev on 29.04.2018.
 */
interface MovieService {

    @GET("popular/")
    fun popularMovies(): Single<MoviesResponse>

    @GET("top_rated/")
    fun topRatedMovies(): Single<MoviesResponse>

    @GET("/genre/movie/list")
    fun getGenreList(): Single<List<Genre>>
}
