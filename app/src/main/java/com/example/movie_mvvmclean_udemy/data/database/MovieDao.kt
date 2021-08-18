package com.example.movie_mvvmclean_udemy.data.database

import androidx.room.*
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("DELETE FROM popular_movie")
    suspend fun deleteMovie(movies: List<Movie>)

    @Query("SELECT * FROM popular_movie")
    suspend fun getMovies(movies: List<Movie>)
}