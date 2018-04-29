package com.itis.android.lessonmvvm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Nail Shaykhraziev on 29.04.2018.
 */
data class Movie(@SerializedName("id")
                 val id: Int?,
                 @SerializedName("title")
                 val title: String,
                 @SerializedName("vote_count")
                 val voteCount: Int?,
                 @SerializedName("vote_average")
                 val voteAverage: Int?,
                 @SerializedName("poster_path")
                 val posterPath: String,
                 @SerializedName("release_date")
                 val releaseDate: String,
                 @SerializedName("overview")
                 val overview: String,
                 @SerializedName("genre_ids")
                 val genres: List<Int>?)
