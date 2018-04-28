package com.itis.android.lessonmvvm.di.module

import android.content.Context
import org.kodein.di.Kodein
import com.jakewharton.picasso.OkHttp3Downloader
import okhttp3.OkHttpClient
import com.squareup.picasso.Picasso
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider


/**
 * Created by Nail Shaykhraziev on 28.04.2018.
 */
fun picassoModule() = Kodein.Module {
    bind<Picasso>() with provider { providePicasso(instance(), instance()) }
    bind<OkHttp3Downloader>() with provider { provideOkHttp3Downloader(instance()) }
}

private fun providePicasso(context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso =
        Picasso.Builder(context).downloader(okHttp3Downloader).build()


private fun provideOkHttp3Downloader(okHttpClient: OkHttpClient): OkHttp3Downloader =
        OkHttp3Downloader(okHttpClient)
