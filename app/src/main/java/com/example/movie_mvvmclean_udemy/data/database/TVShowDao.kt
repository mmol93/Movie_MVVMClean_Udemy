package com.example.movie_mvvmclean_udemy.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<TVShow>)

    @Query("DELETE FROM popular_tvShow")
    suspend fun deleteMovie(movies: List<TVShow>)

    @Query("SELECT * FROM popular_tvShow")
    suspend fun getMovies(movies: List<TVShow>)
}