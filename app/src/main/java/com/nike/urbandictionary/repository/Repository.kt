package com.nike.urbandictionary.repository

import com.nike.urbandictionary.api.model.Definition


interface Repository {

    suspend fun getResultFromNetwork(term: String): List<Definition>?
}