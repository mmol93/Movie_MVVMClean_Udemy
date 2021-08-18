package com.example.movie_mvvmclean_udemy.data
import com.google.gson.annotations.SerializedName

data class TVList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)