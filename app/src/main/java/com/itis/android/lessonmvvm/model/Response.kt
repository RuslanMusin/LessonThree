package com.itis.android.lessonmvvm.model

/**
 * Created by Nail Shaykhraziev on 29.04.2018.
 */
class Response<T>(val data: T?, val error: Throwable?) {

    companion object {
        fun <T> success(data: T): Response<T> = Response(data, null)

        fun <T> error(error: Throwable): Response<T> = Response(null, error)
    }
}
