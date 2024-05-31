package com.Test.interviewtest.data.datasource

import com.Test.interviewtest.domain.model.MovieResponse
import com.Test.interviewtest.domain.network.get_movies
import io.ktor.client.HttpClient
import io.ktor.client.request.get



class MovieDataSourceImpl(private val client:HttpClient) : MovieDataSource {
    override suspend fun getMovieList(): MovieResponse {
        return client.get(get_movies)

    }
}