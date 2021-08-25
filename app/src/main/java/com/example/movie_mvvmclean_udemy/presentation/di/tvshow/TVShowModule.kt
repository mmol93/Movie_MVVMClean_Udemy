package com.example.movie_mvvmclean_udemy.presentation.di.tvshow

import com.example.movie_mvvmclean_udemy.data.domain.usecase.GetArtistUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.GetTVShowUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.UpdateArtistUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.UpdateTvShowUseCase
import com.example.movie_mvvmclean_udemy.presentation.artist.ArtistViewModelFactory
import com.example.movie_mvvmclean_udemy.presentation.tvShow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {
    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowUseCase: GetTVShowUseCase,
        updateTVShowUseCase: UpdateTvShowUseCase) : TVShowViewModelFactory {
        return TVShowViewModelFactory(getTVShowUseCase, updateTVShowUseCase)
    }
}