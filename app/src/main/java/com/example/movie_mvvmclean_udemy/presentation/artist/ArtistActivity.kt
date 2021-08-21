package com.example.movie_mvvmclean_udemy.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.movie_mvvmclean_udemy.R
import com.example.movie_mvvmclean_udemy.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    lateinit var binder : ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}