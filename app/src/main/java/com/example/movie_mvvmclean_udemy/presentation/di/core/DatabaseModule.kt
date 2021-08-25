package com.example.movie_mvvmclean_udemy.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.movie_mvvmclean_udemy.data.database.ArtistDao
import com.example.movie_mvvmclean_udemy.data.database.MovieDao
import com.example.movie_mvvmclean_udemy.data.database.TMDBDatabase
import com.example.movie_mvvmclean_udemy.data.database.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTVShowDAO(tmdbDatabase: TMDBDatabase):TVShowDao{
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDAO(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }
}