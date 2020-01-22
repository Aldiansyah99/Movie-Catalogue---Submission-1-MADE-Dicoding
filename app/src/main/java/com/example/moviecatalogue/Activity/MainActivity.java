package com.example.moviecatalogue.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.moviecatalogue.Model.Movie;
import com.example.moviecatalogue.Adapter.MovieAdapter;
import com.example.moviecatalogue.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private String[] dataTitle;
    private String[] dataGenre;
    private String[] dataRating;
    private String[] dataDescription;
    private String[] dataRuntime;
    private TypedArray dataImage;
    private TypedArray dataCover;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = findViewById(R.id.list_view);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        dataMovie();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ArrayList<Movie> movies = new ArrayList<>();

                Movie movie = new Movie();
                movie.setCover(dataCover.getResourceId(i, -1));
                movie.setImage(dataImage.getResourceId(i, -1));
                movie.setTitle(dataTitle[i]);
                movie.setGenre(dataGenre[i]);
                movie.setRating(dataRating[i]);
                movie.setDescription(dataDescription[i]);
                movie.setRuntime(dataRuntime[i]);

                movies.add(movie);

                Intent moveWithObject = new Intent(MainActivity.this, DetailMovieActivity.class);
                moveWithObject.putParcelableArrayListExtra(DetailMovieActivity.EXTRA_MOVIE, movies);
                startActivity(moveWithObject);
            }
        });

    }

    public void dataMovie() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataImage = getResources().obtainTypedArray(R.array.data_image);
        dataCover = getResources().obtainTypedArray(R.array.data_imageCover);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setImage(dataImage.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setGenre(dataGenre[i]);
            movie.setRating(dataRating[i]);
            movie.setDescription(dataDescription[i]);
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }
}
