package com.example.housingapp

import android.app.Application
import com.example.housingapp.di.AppComponent
import com.example.housingapp.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy(
        DaggerAppComponent
            .builder()
            .applicationContext(this)::build
    )

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        internal lateinit var instance: App
            private set
    }

}