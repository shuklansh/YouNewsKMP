package com.example.younewskmp.android

import android.app.Application
import com.example.younewskmp.android.di.viewModelProvidersModule
import com.example.younewskmp.articles.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class YouNewsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelProvidersModule

        startKoin {
            androidContext(this@YouNewsApplication)
            modules(modules)
        }

    }
}