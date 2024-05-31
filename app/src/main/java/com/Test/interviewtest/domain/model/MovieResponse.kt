package com.Test.interviewtest.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class MovieResponse(
    @SerialName("title")
    val title: String?,
    @SerialName("homeData")
    val homeData: List<HomeData?>?
)