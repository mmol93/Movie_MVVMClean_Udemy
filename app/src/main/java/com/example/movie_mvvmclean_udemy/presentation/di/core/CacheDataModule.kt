package com.example.movie_mvvmclean_udemy.presentation.di.core

import com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data.ArtistCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data.ArtistCacheDataSourceImpl
import com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data.MovieCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.movie.cache_data.MovieCacheDataSourceImpl
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.cache_data.TvShowCacheDataSource
import com.example.movie_mvvmclean_udemy.data.repository.tvshow.cache_data.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource():TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
}