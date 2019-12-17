package com.example.themoviedb.models

import com.google.gson.annotations.SerializedName

data class GetMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val total_pages: Int
)