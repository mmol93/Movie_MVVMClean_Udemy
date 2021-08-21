package com.example.movie_mvvmclean_udemy.data.model.artist
import com.google.gson.annotations.SerializedName

// data key from JSON data
data class ArtistList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val artists: List<Artist>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)