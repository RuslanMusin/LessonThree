package com.itis.android.lessonmvvm.api


import com.itis.android.lessonmvvm.BuildConfig
import com.itis.android.lessonmvvm.utils.API_KEY_PARAM
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiKeyInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        return chain.proceed(original.newBuilder()
                .url(getUrl(original))
                .build())
    }

    private fun getUrl(request: Request): HttpUrl {
        val key = BuildConfig.API_KEY
        return request.url().newBuilder()
                .addQueryParameter(API_KEY_PARAM, key)
                .build()
    }
}
