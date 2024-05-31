package com.Test.interviewtest.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class HomeData(
    @SerialName("id")
    val id: String?,
    @SerialName("genre")
    val genre: String?,
    @SerialName("type")
    val type: Int?,
    @SerialName("movieslist")
    val movieslist: List<Movieslist?>?
)