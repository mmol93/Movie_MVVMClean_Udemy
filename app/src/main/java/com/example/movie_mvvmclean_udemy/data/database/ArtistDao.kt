package com.example.movie_mvvmclean_udemy.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie_mvvmclean_udemy.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteMovie(movies: List<Artist>)

    @Query("SELECT * FROM popular_artist")
    suspend fun getMovies(movies: List<Artist>)
}