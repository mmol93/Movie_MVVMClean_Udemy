package com.example.movie_mvvmclean_udemy.presentation.di.artist

import com.example.movie_mvvmclean_udemy.data.domain.usecase.GetArtistUseCase
import com.example.movie_mvvmclean_udemy.data.domain.usecase.UpdateArtistUseCase
import com.example.movie_mvvmclean_udemy.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase) : ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}