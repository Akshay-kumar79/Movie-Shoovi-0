package com.example.movieshoovi;

import androidx.lifecycle.MutableLiveData;

import com.example.movieshoovi.models.MovieModel;
import com.example.movieshoovi.request.MovieApi;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MovieApiClient {

    private MutableLiveData<List<MovieModel>> movies;

    private static MovieApiClient instance;

    private MovieApiClient(){
        movies = new MutableLiveData<>();
    }

    public static MovieApiClient getInstance(){
        if(instance == null){
            instance = new MovieApiClient();
        }
        return instance;
    }

    public MutableLiveData<List<MovieModel>> getMovies() {
        return movies;
    }

//    public void searchMovieApi(){
//        final Future myHandler = AppExecutors.getInstance().networkIO().submit();
//
//        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
//            @Override
//            public void run() {
//                myHandler.cancel(true);
//            }
//        },5000, TimeUnit.MICROSECONDS);
//    }

//    private class RetrieveMoviesRunnable implements Runnable{
//
//        @Override
//        public void run() {
//
//        }
//    }

}
