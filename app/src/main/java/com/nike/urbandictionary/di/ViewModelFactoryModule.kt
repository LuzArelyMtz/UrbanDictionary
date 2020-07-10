package com.nike.urbandictionary.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import net.aptivist.daggerbase.dagger.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}