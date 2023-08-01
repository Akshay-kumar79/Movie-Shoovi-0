package com.example.movieshoovi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieshoovi.models.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListHolder> {

    private List<MovieModel> myMovieList;
    Context mContext;

    public MovieListAdapter(Context context, List<MovieModel> myMovieList) {
        this.myMovieList = myMovieList;
        this.mContext = context;
    }

    @Override
    public MovieListAdapter.MovieListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_list_item, parent, false);
        return new MovieListAdapter.MovieListHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieListHolder holder, int position) {
        holder.movieNameTextView.setText(myMovieList.get(position).getTitle());
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/original/"+myMovieList.get(position).getPoster_path())
                .into(holder.movieThumbnailImageView);
    }

    @Override
    public int getItemCount() {
        return myMovieList.size();
    }

    public class MovieListHolder extends RecyclerView.ViewHolder{

        TextView movieNameTextView;
        ImageView movieThumbnailImageView;

        public MovieListHolder(View itemView) {
            super(itemView);
            movieNameTextView = itemView.findViewById(R.id.movie_name);
            movieThumbnailImageView = itemView.findViewById(R.id.movie_thumbnail);
        }
    }

}
