package com.ntss.popmovie.data.single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ntss.popmovie.data.models.MovieDetails
import com.ntss.popmovie.data.repository.MovieDetailsRepo
import com.ntss.popmovie.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepo: MovieDetailsRepo, movieId: Int) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepo.fetchSingleMovieDetails(compositeDisposable, movieId)
    }
    val networkState: LiveData<NetworkState> by lazy {
        movieRepo.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}