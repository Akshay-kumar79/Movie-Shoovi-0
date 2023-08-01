package com.example.movieshoovi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.movieshoovi.models.MovieModel;
import com.example.movieshoovi.request.MovieApi;
import com.example.movieshoovi.request.Servicey;
import com.example.movieshoovi.response.MovieSearchResponse;
import com.example.movieshoovi.utils.Credentials;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView movieListRecyclerView;
    MovieListAdapter adapter;
    MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListRecyclerView = findViewById(R.id.movie_list_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        movieListRecyclerView.setLayoutManager(gridLayoutManager);

        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                // update ui
            }
        });

        MovieApi movieApi = Servicey.getMovieApi();
        Call<MovieSearchResponse> responseCall = movieApi.getSearchedMovie(Credentials.API_KEY, "fast and furious", "1");

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200){
                    adapter = new MovieListAdapter(MainActivity.this, response.body().getMovies());
                    for(MovieModel movie : response.body().getMovies()){
                        Log.v("MainActivity", movie.getTitle());
                    }
                    movieListRecyclerView.setAdapter(adapter);

                }else{
                    Toast.makeText(MainActivity.this, "error!!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });

    }
}