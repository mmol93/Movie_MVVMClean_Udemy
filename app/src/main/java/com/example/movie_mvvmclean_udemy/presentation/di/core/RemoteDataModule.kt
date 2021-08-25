package com.example.movie_mvvmclean_udemy.presentation.di.core

import com.example.movie_mvvmclean_udemy.data.api.TMDBService
import com.example.movie_mvvmclean_udemy.data.repository.artist.remote_data.ArtistRemoteDataSource
import com.example.movie_mvvmclean_udemy.data.repository.artist.remote_data.ArtistRemoteDataSourceImpl
import com.example.movie_mvvmclean_udemy.data.repository.movie.remote_data.MovieRemoteDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.remote_data.MovieRemoteDataSourceImpl
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.remote_data.TVShowRemoteDataSource
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.remote_data.TVShowRemoteDataSourceImpl
import com.example.movie_mvvmclean_udemy.presentation.artist.ArtistViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apikey : String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apikey)
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(tmdbService: TMDBService):TVShowRemoteDataSource{
        return TVShowRemoteDataSourceImpl(tmdbService, apikey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apikey)
    }
}