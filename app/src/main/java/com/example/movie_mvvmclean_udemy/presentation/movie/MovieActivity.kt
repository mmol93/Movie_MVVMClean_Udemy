package com.example.movie_mvvmclean_udemy.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movie_mvvmclean_udemy.R
import com.example.movie_mvvmclean_udemy.databinding.ActivityMovieBinding
import com.example.movie_mvvmclean_udemy.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieVieModel : MovieViewModel
    private lateinit var binder : ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieVieModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        val responseLiveData = movieVieModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.d("test", it.toString())
        })
    }
}