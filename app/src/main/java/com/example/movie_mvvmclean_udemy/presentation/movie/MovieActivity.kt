package com.example.movie_mvvmclean_udemy.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.movie_mvvmclean_udemy.R
import com.example.movie_mvvmclean_udemy.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binder : ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }
}