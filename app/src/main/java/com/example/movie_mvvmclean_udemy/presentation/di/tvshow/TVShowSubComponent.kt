package com.example.movie_mvvmclean_udemy.presentation.di.tvshow

import com.example.movie_mvvmclean_udemy.presentation.artist.ArtistActivity
import com.example.movie_mvvmclean_udemy.presentation.movie.MovieActivity
import com.example.movie_mvvmclean_udemy.presentation.tvShow.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TVShowSubComponent
    }
}