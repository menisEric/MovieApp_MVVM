package com.ericmenis.moviemvvm.data.api

import com.ericmenis.moviemvvm.data.vo.MovieDetails
import com.ericmenis.moviemvvm.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    //https://api.themoviedb.org/3/movie/popular?api_key=959efe819163a9755af52df95101278f&language=en-US
    //https://api.themoviedb.org/3/movie/299534?api_key=959efe819163a9755af52df95101278f
    //https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopular(@Query("page")page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")id: Int): Single<MovieDetails>
}