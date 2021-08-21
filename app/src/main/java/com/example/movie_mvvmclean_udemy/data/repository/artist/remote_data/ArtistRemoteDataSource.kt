package com.example.movie_mvvmclean_udemy.data.repository.artist.remote_data

import com.example.movie_mvvmclean_udemy.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist() : Response<ArtistList>
}