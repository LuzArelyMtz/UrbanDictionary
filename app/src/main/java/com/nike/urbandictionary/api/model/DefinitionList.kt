package com.nike.urbandictionary.api.model

import com.google.gson.annotations.SerializedName

data class DefinitionList(
    @SerializedName("list")
    var searchResultsList: List<Definition>
)