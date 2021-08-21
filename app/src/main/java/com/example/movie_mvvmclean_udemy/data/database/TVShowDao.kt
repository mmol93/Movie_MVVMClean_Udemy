package com.example.movie_mvvmclean_udemy.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShow(tvShow : List<TVShow>)

    @Query("DELETE FROM popular_tvShow")
    suspend fun clearTvShow()

    @Query("SELECT * FROM popular_tvShow")
    suspend fun getTVShows(): List<TVShow>
}