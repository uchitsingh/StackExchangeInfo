package com.example.stackexchangeinfo

import android.app.Application
import com.example.stackexchangeinfo.dagger.AppComponent
import com.example.stackexchangeinfo.dagger.AppModule
import com.example.stackexchangeinfo.dagger.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        appComponent = initDagger()
    }

    private fun initDagger(): AppComponent =
        DaggerAppComponent.builder().appModule(AppModule()).build()
}