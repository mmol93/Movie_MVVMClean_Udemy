package com.example.movie_mvvmclean_udemy.data.database

import androidx.room.*
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie
import retrofit2.http.DELETE

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("DELETE FROM popular_movie")
    suspend fun clearMovie()

    @Query("SELECT * FROM popular_movie")
    suspend fun getMovies() : List<Movie>
}