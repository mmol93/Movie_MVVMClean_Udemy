package com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data

import com.example.movie_mvvmclean_udemy.data.model.movie.Movie

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}