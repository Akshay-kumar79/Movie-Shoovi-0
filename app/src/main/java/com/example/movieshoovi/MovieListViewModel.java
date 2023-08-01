package com.example.movieshoovi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieshoovi.models.MovieModel;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    MovieRepository repository;

    public MovieListViewModel(){
        repository = MovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies() {
        return repository.getMovies();
    }
}
