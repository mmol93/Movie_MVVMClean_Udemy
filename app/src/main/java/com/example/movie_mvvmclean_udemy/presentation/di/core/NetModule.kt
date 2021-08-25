package com.example.movie_mvvmclean_udemy.presentation.di.core

import com.example.movie_mvvmclean_udemy.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseURL:String) {
    // made this function as Singleton
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL).build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit) : TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}