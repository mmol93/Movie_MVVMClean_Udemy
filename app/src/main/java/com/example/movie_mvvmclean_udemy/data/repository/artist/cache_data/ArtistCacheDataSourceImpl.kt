package com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data

import com.example.movie_mvvmclean_udemy.data.model.artist.Artist

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun saveArtistsToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }
}