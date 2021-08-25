package com.example.movie_mvvmclean_udemy.presentation.di.movie

import com.example.movie_mvvmclean_udemy.presentation.artist.ArtistActivity
import com.example.movie_mvvmclean_udemy.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}