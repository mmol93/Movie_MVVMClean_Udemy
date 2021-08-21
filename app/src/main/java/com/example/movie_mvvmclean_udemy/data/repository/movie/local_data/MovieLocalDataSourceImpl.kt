package com.example.movie_mvvmclean_udemy.data.repository.movie.local_data

import com.example.movie_mvvmclean_udemy.data.database.MovieDao
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao : MovieDao) : MovieLocalDataSource {
    override suspend fun getMovieFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.clearMovie()
        }
    }
}