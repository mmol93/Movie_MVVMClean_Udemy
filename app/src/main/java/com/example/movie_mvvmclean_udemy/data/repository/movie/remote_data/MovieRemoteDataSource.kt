package com.example.movie_mvvmclean_udemy.data.repository.movie.remote_data

import com.example.movie_mvvmclean_udemy.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies() : Response<MovieList>
}