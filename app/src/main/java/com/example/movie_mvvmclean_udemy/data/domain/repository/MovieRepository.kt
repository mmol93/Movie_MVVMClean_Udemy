package com.example.movie_mvvmclean_udemy.data.domain.repository

import com.example.movie_mvvmclean_udemy.data.model.movie.Movie

interface MovieRepository{
    // get Movie data
    suspend fun getMovies() : List<Movie>?

    // update Movie data
    suspend fun updateMovies() : List<Movie>?
}