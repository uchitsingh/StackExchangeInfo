package com.example.stackexchangeinfo.dagger

import com.example.stackexchangeinfo.ui.UserActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(userActivity: UserActivity)

}