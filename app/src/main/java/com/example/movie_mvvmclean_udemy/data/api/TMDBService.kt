package com.example.movie_mvvmclean_udemy.data.api

import com.example.movie_mvvmclean_udemy.data.ArtistList
import com.example.movie_mvvmclean_udemy.data.MovieList
import com.example.movie_mvvmclean_udemy.data.TVList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apikey:String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key")apikey:String) : Response<TVList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key")apikey:String) : Response<ArtistList>
}