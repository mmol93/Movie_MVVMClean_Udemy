package com.example.movie_mvvmclean_udemy.data.repository.artist.remote_data

import com.example.movie_mvvmclean_udemy.data.api.TMDBService
import com.example.movie_mvvmclean_udemy.data.model.artist.ArtistList
import com.example.movie_mvvmclean_udemy.data.model.movie.MovieList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apikey : String) : ArtistRemoteDataSource {
    // you can get movie data from Room database(@Get(~~))
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apikey)
    }
}