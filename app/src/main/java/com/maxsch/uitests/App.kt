package com.maxsch.uitests

import android.app.Application
import com.maxsch.data.di.dataModule
import com.maxsch.domain.di.domainModule
import com.maxsch.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, presentationModule, dataModule, domainModule)
        }
    }
}