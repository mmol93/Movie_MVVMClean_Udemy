package com.example.movie_mvvmclean_udemy.presentation.di.movie

import com.example.movie_mvvmclean_udemy.data.domain.usecase.GetArtistUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.GetMoviesUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.UpdateArtistUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.UpdateMovieUseCase
import com.example.movie_mvvmclean_udemy.presentation.artist.ArtistViewModelFactory
import com.example.movie_mvvmclean_udemy.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase) : MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }
}