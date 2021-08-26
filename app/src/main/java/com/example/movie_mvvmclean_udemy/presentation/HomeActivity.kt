package com.example.movie_mvvmclean_udemy.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.movie_mvvmclean_udemy.R
import com.example.movie_mvvmclean_udemy.databinding.ActivityHomeBinding
import com.example.movie_mvvmclean_udemy.presentation.artist.ArtistActivity
import com.example.movie_mvvmclean_udemy.presentation.movie.MovieActivity
import com.example.movie_mvvmclean_udemy.presentation.tvShow.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binder : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binder.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binder.tvshowButton.setOnClickListener {
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }

        binder.artistButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }

}