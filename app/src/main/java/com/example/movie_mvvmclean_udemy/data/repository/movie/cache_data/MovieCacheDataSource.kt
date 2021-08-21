package com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data

import com.example.movie_mvvmclean_udemy.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun saveMoviesToCache(movies: List<Movie>)

    suspend fun getMoviesFromCache():List<Movie>
}