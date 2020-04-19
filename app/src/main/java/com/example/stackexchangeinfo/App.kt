package com.example.stackexchangeinfo

import android.app.Application
import com.example.stackexchangeinfo.dagger.AppComponent
import com.example.stackexchangeinfo.dagger.AppModule
import com.example.stackexchangeinfo.dagger.DaggerAppComponent
import timber.log.Timber

class App: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
        Timber.plant(Timber.DebugTree())
    }

    private fun initDagger(): AppComponent =
        DaggerAppComponent.builder().appModule(AppModule()).build()
}