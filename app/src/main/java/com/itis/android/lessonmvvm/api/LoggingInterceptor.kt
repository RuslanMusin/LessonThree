package com.itis.android.lessonmvvm.api

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import com.itis.android.lessonmvvm.BuildConfig
import okhttp3.Response
import java.io.IOException

/**
 * Created by Nail Shaykhraziev on 28.04.2018.
 */
class LoggingInterceptor(
        private val loggingInterceptor: HttpLoggingInterceptor =
                HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG)
                            HttpLoggingInterceptor.Level.BODY
                        else
                            HttpLoggingInterceptor.Level.NONE)
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response = loggingInterceptor.intercept(chain)
}