package com.example.themoviedb.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

var key = "f243265c90c1b49e49a6da6d625bc9e4"

interface MovieService {

    @GET("movie/popular/")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = key,
        @Query("page") page: Int
    ): Call<GetMovieResponse>

    @GET("movie/top_rated/")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = key,
        @Query("page") page: Int
    ): Call<GetMovieResponse>

    @GET("movie/upcoming/")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = key,
        @Query("page") page: Int
    ): Call<GetMovieResponse>
}