package com.Test.interviewtest.data.datasource

import com.Test.interviewtest.domain.model.MovieResponse

interface MovieDataSource {

    suspend fun getMovieList():MovieResponse
}