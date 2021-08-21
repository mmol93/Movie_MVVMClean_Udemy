package com.example.movie_mvvmclean_udemy.data.repository.movie.local_data

import com.example.movie_mvvmclean_udemy.data.model.artist.Artist
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB() : List<Artist>
    suspend fun saveArtistToDB(artists:List<Artist>)
    suspend fun clearAll()
}