package com.ntss.popmovie.data.repository
import androidx.lifecycle.LiveData
import com.ntss.popmovie.data.api.TheMovieDBInterface
import com.ntss.popmovie.data.models.MovieDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable

class MovieDetailsRepo(private val apiService : TheMovieDBInterface) {
    lateinit var movieDetailsDataSource: MovieDetailsDataSource
    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable,movieId:Int):LiveData<MovieDetails>{
        movieDetailsDataSource=MovieDetailsDataSource(apiService,compositeDisposable)
        movieDetailsDataSource.fetchMovieDetails(movieId)
        return movieDetailsDataSource.downloadedMovieDetailsResponse

    }
    
}