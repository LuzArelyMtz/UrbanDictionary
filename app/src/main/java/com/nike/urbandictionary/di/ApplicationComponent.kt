package com.nike.urbandictionary.di

import com.nike.urbandictionary.view.MainActivity
import com.nike.urbandictionary.api.UrbanDictionaryModule
import dagger.Component
import net.aptivist.daggerbase.dagger.modules.MainViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, MainViewModelModule::class, UrbanDictionaryModule::class, RepositoryModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}