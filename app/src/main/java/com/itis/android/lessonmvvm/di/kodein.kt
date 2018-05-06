package com.itis.android.lessonmvvm.di

import android.app.Application
import com.itis.android.lessonmvvm.di.module.appModule
import com.itis.android.lessonmvvm.di.module.netModule
import com.itis.android.lessonmvvm.di.module.picassoModule
import com.itis.android.lessonmvvm.ui.ViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * Created by Nail Shaykhraziev on 28.04.2018.
 */
lateinit var di: Kodein

fun initKodein(app: Application) {
    di = Kodein {
        import(appModule(app))
        import(netModule())
        import(picassoModule())
        bind<ViewModelFactory>() with singleton { ViewModelFactory(instance()) }
    }
}