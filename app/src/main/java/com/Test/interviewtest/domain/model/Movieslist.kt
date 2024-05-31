package com.Test.interviewtest.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class Movieslist(
    @SerialName("id")
    val id: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("desc")
    val desc: String?,
    @SerialName("genre")
    val genre: List<String>?,
    @SerialName("release")
    val release: String?,
    @SerialName("posterurl")
    val posterurl: String?,
    @SerialName("rating")
    val rating: String?
)