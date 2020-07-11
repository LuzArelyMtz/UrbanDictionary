package com.nike.urbandictionary.di

import com.nike.urbandictionary.api.UrbanDictionaryService
import com.nike.urbandictionary.repository.Repository
import com.nike.urbandictionary.repository.UrbanDictionaryRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(urbanDictionaryService: UrbanDictionaryService): Repository {
        return UrbanDictionaryRepository(urbanDictionaryService)
    }
}