package com.nike.urbandictionary

import android.app.Application
import com.nike.urbandictionary.di.ApplicationComponent
import com.nike.urbandictionary.di.ApplicationModule
import com.nike.urbandictionary.di.DaggerApplicationComponent

class MyApplication : Application() {
    lateinit var appComponent: ApplicationComponent

    private fun initDagger(application: MyApplication): ApplicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(application))
            .build()

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }
}