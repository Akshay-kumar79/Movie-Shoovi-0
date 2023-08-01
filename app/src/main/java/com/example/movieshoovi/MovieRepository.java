package com.example.movieshoovi;

import androidx.lifecycle.MutableLiveData;

import com.example.movieshoovi.models.MovieModel;

import java.util.List;

public class MovieRepository {

    private MovieApiClient apiClient;

    private static MovieRepository instance;

    private MovieRepository(){
        apiClient = MovieApiClient.getInstance();
    }

    public static MovieRepository getInstance(){
        if(instance == null){
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<List<MovieModel>> getMovies() {
        return apiClient.getMovies();
    }
}
