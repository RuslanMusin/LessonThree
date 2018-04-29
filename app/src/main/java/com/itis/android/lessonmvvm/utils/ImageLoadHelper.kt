package com.itis.android.lessonmvvm.utils

import android.widget.ImageView
import com.itis.android.lessonmvvm.BuildConfig
import com.itis.android.lessonmvvm.R
import com.squareup.picasso.Picasso

fun loadPicture(imageView: ImageView, posterPath: String, size: String) {
    val url = BuildConfig.IMAGE_ENDPOINT + size + posterPath
    Picasso.with(imageView.context)
            .load(url)
            .error(R.drawable.image_error)
            .noFade()
            .into(imageView)
}
