package com.example.movieshoovi.request;

import com.example.movieshoovi.response.MovieResponse;
import com.example.movieshoovi.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    // https://api.themoviedb.org/  3/search/movie   ?    api_key=42c45bbf2213e62229c83be2ca898abf&query=Jack+Reacher
    @GET("3/search/movie")
    Call<MovieSearchResponse> getSearchedMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );

    // https://api.themoviedb.org/3/movie/343611?api_key=42c45bbf2213e62229c83be2ca898abf
    @GET("3/movie/{movie_id}?")
    Call<MovieResponse> getMoviebyID(
            @Path("movie_id") int movieId,
            @Query("api_key") String key
    );
}
