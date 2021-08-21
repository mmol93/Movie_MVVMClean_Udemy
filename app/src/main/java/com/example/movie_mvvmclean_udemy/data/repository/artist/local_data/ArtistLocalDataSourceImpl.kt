package com.example.movie_mvvmclean_udemy.data.repository.movie.local_data

import com.example.movie_mvvmclean_udemy.data.database.ArtistDao
import com.example.movie_mvvmclean_udemy.data.database.MovieDao
import com.example.movie_mvvmclean_udemy.data.model.artist.Artist
import com.example.movie_mvvmclean_udemy.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao : ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        artistDao.saveArtist(artists)
    }

    override suspend fun clearAll() {
        artistDao.clearArtist()
    }
}