package com.example.movie_mvvmclean_udemy.presentation

import android.app.Application
import com.example.movie_mvvmclean_udemy.BuildConfig
import com.example.movie_mvvmclean_udemy.presentation.di.Injector
import com.example.movie_mvvmclean_udemy.presentation.di.artist.ArtistSubComponent
import com.example.movie_mvvmclean_udemy.presentation.di.core.*
import com.example.movie_mvvmclean_udemy.presentation.di.movie.MovieSubComponent
import com.example.movie_mvvmclean_udemy.presentation.di.tvshow.TVShowSubComponent

class App : Application(), Injector{
    private lateinit var appComponent : AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()

    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}