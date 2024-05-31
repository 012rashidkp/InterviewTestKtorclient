package com.Test.interviewtest.domain.repository

import com.Test.interviewtest.domain.model.MovieResponse
import com.Test.interviewtest.domain.network.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieList(): Flow<Resource<MovieResponse>>
}