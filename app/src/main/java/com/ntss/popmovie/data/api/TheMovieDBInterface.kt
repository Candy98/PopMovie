package com.ntss.popmovie.data.api

import com.ntss.popmovie.data.models.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

//https://api.themoviedb.org/3/movie/popular?api_key=c04d5c1d0f7d1f6ac0763a186d807483&language=en-US&page=1

interface TheMovieDBInterface {
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")id:Int):Single<MovieDetails>

}