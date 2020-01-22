package com.example.moviecatalogue.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviecatalogue.Model.Movie;
import com.example.moviecatalogue.R;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder {
        private TextView tvTitle;
        private TextView tvGenre;
        private TextView tvRating;
        private TextView tvDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            tvTitle = view.findViewById(R.id.tv_judul_film);
            tvGenre = view.findViewById(R.id.tv_genre_film);
            tvRating = view.findViewById(R.id.tv_rating_film);
            tvDescription = view.findViewById(R.id.tv_description_film);
            imgPhoto = view.findViewById(R.id.img_movie);
        }

        void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvGenre.setText(movie.getGenre());
            tvRating.setText(movie.getRating());
            tvDescription.setText(movie.getDescription());
            imgPhoto.setImageResource(movie.getImage());
        }
    }
}
