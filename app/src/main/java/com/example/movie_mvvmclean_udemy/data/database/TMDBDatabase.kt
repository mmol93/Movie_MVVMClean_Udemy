package com.example.movie_mvvmclean_udemy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movie_mvvmclean_udemy.data.model.artist.Artist
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie
import com.example.movie_mvvmclean_udemy.data.model.tvShow.TVShow

// 데이터 베이스 정의
@Database(entities = [Movie::class, TVShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun movieDao() : MovieDao
    abstract fun tvDao() : TVShowDao
    abstract fun artistDao() : ArtistDao
}