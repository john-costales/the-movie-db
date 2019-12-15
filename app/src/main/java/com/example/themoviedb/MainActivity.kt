package com.example.themoviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.themoviedb.models.Api

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Api.getPopularMovies()
    }
}
