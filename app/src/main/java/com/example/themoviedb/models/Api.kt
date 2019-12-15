package com.example.themoviedb.models

import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object Api {

    private val api: MovieService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()

        api = retrofit.create(MovieService::class.java)
    }

    fun getPopularMovies(
        page: Int = 1
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
                            Log.d("Repository", "Movies: ${responseBody.result}")
                        } else {
                            Log.d("Repository", "Failed to get response")
                        }
                    }
                }

                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    Log.e("Repository", "onFailure", t)
                }
            })
    }

}