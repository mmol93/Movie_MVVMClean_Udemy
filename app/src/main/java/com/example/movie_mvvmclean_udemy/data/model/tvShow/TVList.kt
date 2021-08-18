package com.example.movie_mvvmclean_udemy.data.model.tvShow
import com.google.gson.annotations.SerializedName

data class TVList(
    @SerializedName("results")
    val TVShows: List<TVShow>
)