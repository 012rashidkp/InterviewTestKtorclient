package com.Test.interviewtest.di

import com.Test.interviewtest.data.datasource.MovieDataSource
import com.Test.interviewtest.data.datasource.MovieDataSourceImpl
import com.Test.interviewtest.data.repository.MovieRepositoryImpl
import com.Test.interviewtest.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    @Provides
    @Singleton
    fun ProvideMovieApi(client: HttpClient): MovieDataSource = MovieDataSourceImpl(client)

    @Provides
    fun providMovieRepository(api: MovieDataSource): MovieRepository = MovieRepositoryImpl(api)
}