package com.example.movie_mvvmclean_udemy.presentation.di.core

import com.example.movie_mvvmclean_udemy.data.database.ArtistDao
import com.example.movie_mvvmclean_udemy.data.database.MovieDao
import com.example.movie_mvvmclean_udemy.data.database.TVShowDao
import com.example.movie_mvvmclean_udemy.data.repository.movie.local_data.ArtistLocalDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.local_data.ArtistLocalDataSourceImpl
import com.example.movie_mvvmclean_udemy.data.repository.movie.local_data.MovieLocalDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.local_data.MovieLocalDataSourceImpl
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.local_data.TVShowLocalDataSource
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.local_data.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource {
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}