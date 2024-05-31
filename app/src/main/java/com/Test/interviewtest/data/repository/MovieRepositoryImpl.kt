package com.Test.interviewtest.data.repository

import android.util.Log
import com.Test.interviewtest.data.datasource.MovieDataSource
import com.Test.interviewtest.domain.model.MovieResponse
import com.Test.interviewtest.domain.network.Resource
import com.Test.interviewtest.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {
    override suspend fun getMovieList():Flow<Resource<MovieResponse>> = flow {

        try {
            emit(Resource.Loading())
            val movieResult = dataSource.getMovieList()
            Log.d("datas... ","${movieResult}")
            emit(Resource.Success(data = movieResult))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message?:"Error Occurred!"))
        }


    }
}