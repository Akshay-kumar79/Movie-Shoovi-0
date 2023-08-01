package com.example.movieshoovi.response;

import com.example.movieshoovi.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieSearchResponse {

    @SerializedName("total_results")
    @Expose
    private int totalResults;

    @SerializedName("results")
    @Expose
    private List<MovieModel> movies;

    public int getTotalResults() {
        return totalResults;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "totalResults=" + totalResults +
                ", movies=" + movies +
                '}';
    }
}
