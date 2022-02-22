package com.amarinag.marvelapi.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        marvelAuthInterceptor: MarvelAuthInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .addInterceptor(marvelAuthInterceptor).build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideMarvelApiService(retrofit: Retrofit): MarvelApiService =
        retrofit.create(MarvelApiService::class.java)

}
