package com.example.themoviedb.models

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    private val api: MovieService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MovieService::class.java)
    }

    fun getPopularMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<GetMovieResponse> {
                override fun onResponse(
                    call: Call<GetMovieResponse>,
                    response: Response<GetMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    }
                }

                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getTopRatedMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getTopRatedMovies(page = page)
            .enqueue(object : Callback<GetMovieResponse> {
                override fun onResponse(
                    call: Call<GetMovieResponse>,
                    response: Response<GetMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getUpcomingMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getUpcomingMovies(page = page)
            .enqueue(object : Callback<GetMovieResponse> {
                override fun onResponse(
                    call: Call<GetMovieResponse>,
                    response: Response<GetMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

}