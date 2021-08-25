package com.example.movie_mvvmclean_udemy.presentation.di.core

import com.example.movie_mvvmclean_udemy.presentation.di.artist.ArtistSubComponent
import com.example.movie_mvvmclean_udemy.presentation.di.movie.MovieSubComponent
import com.example.movie_mvvmclean_udemy.presentation.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TVShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}