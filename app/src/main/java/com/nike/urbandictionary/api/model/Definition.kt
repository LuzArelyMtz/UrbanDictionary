package com.nike.urbandictionary.api.model

import com.google.gson.annotations.SerializedName

data class Definition(
    @SerializedName("definition")
    val definition: String,
    @SerializedName("thumbs_up")
    val thumbsUp: Int,
    @SerializedName("thumbs_down")
    val thumbsDown: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("word")
    val word: String,
    @SerializedName("written_on")
    val date: String,
    @SerializedName("example")
    val example: String
)