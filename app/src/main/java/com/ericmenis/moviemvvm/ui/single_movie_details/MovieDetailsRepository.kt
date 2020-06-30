package com.ericmenis.moviemvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.ericmenis.moviemvvm.data.api.TheMovieDBInterface
import com.ericmenis.moviemvvm.data.repository.MovieDetailsNetworkDataSource
import com.ericmenis.moviemvvm.data.repository.NetworkState
import com.ericmenis.moviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails ( compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails>{

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.donwloadedMovieDetailsResponse
    }

    fun getMovieDetailsNetworkState() : LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }

}