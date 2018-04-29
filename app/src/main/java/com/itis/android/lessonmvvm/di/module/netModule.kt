package com.itis.android.lessonmvvm.di.module

import com.itis.android.lessonmvvm.BuildConfig
import com.itis.android.lessonmvvm.api.intercepors.ApiKeyInterceptor
import com.itis.android.lessonmvvm.api.intercepors.LoggingInterceptor
import com.itis.android.lessonmvvm.api.service.MovieService
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Nail Shaykhraziev on 28.04.2018.
 */
fun netModule() = Kodein.Module {

    bind<OkHttpClient>() with singleton { provideOkHttpClient() }
    bind<Retrofit>() with singleton { provideRetrofit(instance()) }
    bind<MovieService>() with singleton { instance<Retrofit>().create(MovieService::class.java) }
}

private fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
                .addInterceptor(ApiKeyInterceptor())
                .addInterceptor(LoggingInterceptor())
                .build()


private fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
