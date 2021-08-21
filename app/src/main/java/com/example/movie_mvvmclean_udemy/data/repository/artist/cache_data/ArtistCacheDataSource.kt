package com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data

import com.example.movie_mvvmclean_udemy.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun saveArtistsToCache(artist: List<Artist>)

    suspend fun getArtistsFromCache():List<Artist>
}