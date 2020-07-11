package com.nike.urbandictionary.api

import com.nike.urbandictionary.BuildConfig
import com.nike.urbandictionary.api.model.DefinitionList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UrbanDictionaryService {

    @Headers(BuildConfig.API_HOST, BuildConfig.API_KEY)
    @GET("define")
    suspend fun getTermUrbanDictionary(@Query("term") term: String): DefinitionList
}