package com.example.testkoin

import android.app.Application
import android.content.Context
import org.koin.core.Koin
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        koin = startKoin {
            modules(mainModule)
        }.koin
        appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
        lateinit var koin: Koin
    }

}