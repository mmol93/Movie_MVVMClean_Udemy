package com.example.movie_mvvmclean_udemy.data.domain.repository

import com.example.movie_mvvmclean_udemy.data.model.artist.Artist

interface ArtistRepository{
    // get Movie data
    suspend fun getArtistShow() : List<Artist>?

    // update Movie data
    suspend fun updateArtistShow() : List<Artist>?
}