package com.example.movie_mvvmclean_udemy.presentation.di.core

import com.example.Artist_mvvmclean_udemy.data.repository.artist.ArtistRepositoryImpl
import com.example.movie_mvvmclean_udemy.data.domain.repository.ArtistRepository
import com.example.movie_mvvmclean_udemy.data.domain.repository.MovieRepository
import com.example.movie_mvvmclean_udemy.data.domain.repository.TVShowRepository
import com.example.movie_mvvmclean_udemy.data.repository.artist.remote_data.ArtistRemoteDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.MovieRepositoryImpl
import com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data.ArtistCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data.MovieCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.local_data.ArtistLocalDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.local_data.MovieLocalDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.remote_data.MovieRemoteDataSource
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.TVShowRepositoryImpl
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.cache_data.TvShowCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.local_data.TVShowLocalDataSource
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.remote_data.TVShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TVShowRepository {
        return TVShowRepositoryImpl(tvRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}