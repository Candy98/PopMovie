package com.ntss.popmovie.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ntss.popmovie.data.api.TheMovieDBInterface
import com.ntss.popmovie.data.models.MovieDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDetailsDataSource(
    private val apiService: TheMovieDBInterface,
    private val compositeDisposable: CompositeDisposable
) {
    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState
    private val _downloadedMovieDetailsResponse = MutableLiveData<MovieDetails>()
    val downloadedMovieDetailsResponse: LiveData<MovieDetails>
        get() = _downloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId: Int) {
        _networkState.postValue(NetworkState.LOADING)
        try {

compositeDisposable.add(
    apiService.getMovieDetails(movieId)
        .subscribeOn(Schedulers.io())
        .subscribe(
            {
                _downloadedMovieDetailsResponse.postValue(it)
                _networkState.postValue(NetworkState.LOADED)
            },
            {
                _networkState.postValue(NetworkState.ERROR)
                Log.e("Movie details problem ${it.message}","")
            }

        )

)
        } catch (e: Exception) {

        }
    }


}