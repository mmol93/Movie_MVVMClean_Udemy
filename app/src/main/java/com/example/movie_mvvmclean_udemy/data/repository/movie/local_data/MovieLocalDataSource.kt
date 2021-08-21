package com.example.movie_mvvmclean_udemy.data.repository.movie.local_data

import com.example.movie_mvvmclean_udemy.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMovieFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}