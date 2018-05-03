package com.itis.android.lessonmvvm.di

import android.app.Application
import com.itis.android.lessonmvvm.di.module.appModule
import com.itis.android.lessonmvvm.di.module.netModule
import com.itis.android.lessonmvvm.di.module.picassoModule
import org.kodein.di.Kodein

/**
 * Created by Nail Shaykhraziev on 28.04.2018.
 */
lateinit var di: Kodein

fun initKodein(app: Application) {
    di = Kodein {
        import(appModule(app))
        import(netModule())
        import(picassoModule())
    }
}