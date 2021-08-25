package com.example.movie_mvvmclean_udemy.presentation.di

import com.example.movie_mvvmclean_udemy.presentation.di.artist.ArtistSubComponent
import com.example.movie_mvvmclean_udemy.presentation.di.movie.MovieSubComponent
import com.example.movie_mvvmclean_udemy.presentation.di.tvshow.TVShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTVShowSubComponent():TVShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}