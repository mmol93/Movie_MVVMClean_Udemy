package com.example.movie_mvvmclean_udemy.data


import com.example.movie_mvvmclean_udemy.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
    )