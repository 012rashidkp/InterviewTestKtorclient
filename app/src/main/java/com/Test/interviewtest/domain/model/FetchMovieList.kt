package com.Test.interviewtest.domain.model




data class FetchMovieList(
    val id: String?,
    val title: String?,
    val desc: String?,
    val genre: List<String?>?,
    val release: String?,
    val posterurl: String?,
    val rating: String?
)
