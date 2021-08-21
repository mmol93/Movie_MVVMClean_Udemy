package com.example.movie_mvvmclean_udemy.data.domain.usecase

import com.example.movie_mvvmclean_udemy.data.domain.repository.MovieRepository
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() : List<Movie>? = movieRepository.getMovies()
}