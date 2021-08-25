package com.example.movie_mvvmclean_udemy.presentation.di.core

import android.content.Context
import com.example.movie_mvvmclean_udemy.presentation.di.artist.ArtistSubComponent
import com.example.movie_mvvmclean_udemy.presentation.di.movie.MovieSubComponent
import com.example.movie_mvvmclean_udemy.presentation.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TVShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}