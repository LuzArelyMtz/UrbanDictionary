package com.nike.urbandictionary.repository

import com.nike.urbandictionary.api.UrbanDictionaryService
import com.nike.urbandictionary.api.model.Definition
import javax.inject.Inject

class UrbanDictionaryRepository @Inject constructor(private val urbanDictionaryService: UrbanDictionaryService) :
    Repository {
    override suspend fun getResultFromNetwork(term: String): List<Definition>? {
        return urbanDictionaryService.getTermUrbanDictionary(term).body()?.searchResultsList
    }
}