package com.ntss.popmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ntss.popmovie.data.api.TheMovieDBClient
import com.ntss.popmovie.data.models.MovieDetails
import com.ntss.popmovie.data.repository.MovieDetailsRepo
import com.ntss.popmovie.data.single_movie_details.SingleMovieViewModel

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: SingleMovieViewModel
    private lateinit var movieRepo: MovieDetailsRepo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movieId:Int=1
        val apiService=TheMovieDBClient.getClient()
        movieRepo = MovieDetailsRepo(apiService)
        viewModel=getViewModel(movieId)
        viewModel.movieDetails.observe(this, Observer {
            updateUI(it)
        })


    }

    private fun updateUI(it: MovieDetails?) {


    }

    private fun getViewModel(movieId:Int):SingleMovieViewModel{
        return ViewModelProviders.of(this,object :ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
               @Suppress("UNCHECKED_CAST")
               return  SingleMovieViewModel(movieRepo,movieId)as T
            }

        })[SingleMovieViewModel::class.java]
    }
}