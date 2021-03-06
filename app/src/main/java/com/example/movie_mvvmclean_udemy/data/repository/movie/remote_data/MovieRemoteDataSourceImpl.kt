package com.example.movie_mvvmclean_udemy.data.repository.movie.remote_data

import com.example.movie_mvvmclean_udemy.data.api.TMDBService
import com.example.movie_mvvmclean_udemy.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
private val apikey : String) : MovieRemoteDataSource {
    // you can get movie data from Room database(@Get(~~))
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apikey)
    }
}