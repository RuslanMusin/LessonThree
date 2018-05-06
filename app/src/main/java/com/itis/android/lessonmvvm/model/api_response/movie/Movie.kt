package com.itis.android.lessonmvvm.model.api_response.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Nail Shaykhraziev on 29.04.2018.
 */
@Parcelize
data class Movie(@SerializedName("id")
                 val id: Int?,
                 @SerializedName("title")
                 val title: String,
                 @SerializedName("vote_count")
                 val voteCount: Int?,
                 @SerializedName("vote_average")
                 val voteAverage: Double?,
                 @SerializedName("poster_path")
                 val posterPath: String,
                 @SerializedName("release_date")
                 val releaseDate: String,
                 @SerializedName("overview")
                 val overview: String,
                 @SerializedName("genre_ids")
                 val genres: List<Int>?) : Parcelable
