package com.example.movie_mvvmclean_udemy.presentation.di.core

import com.example.movie_mvvmclean_udemy.data.domain.repository.ArtistRepository
import com.example.movie_mvvmclean_udemy.data.domain.repository.MovieRepository
import com.example.movie_mvvmclean_udemy.data.domain.repository.TVShowRepository
import com.example.movie_mvvmclean_udemy.data.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetTVShowUseCase(tvShowRepository: TVShowRepository):GetTVShowUseCase{
        return GetTVShowUseCase((tvShowRepository))
    }
    @Provides
    fun provideUpdateTVShowUseCase(tvShowRepository: TVShowRepository):UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }
}