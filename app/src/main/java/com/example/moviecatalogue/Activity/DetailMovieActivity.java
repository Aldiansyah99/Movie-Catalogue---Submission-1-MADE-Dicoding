package com.example.moviecatalogue.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviecatalogue.Model.Movie;
import com.example.moviecatalogue.R;

import java.util.ArrayList;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    ImageView imgCover, imgPhoto;
    TextView tvTitle, tvGenre, tvRating, tvDescription, tvRuntime;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgCover = findViewById(R.id.img_detail_cover);
        imgPhoto = findViewById(R.id.img_detail_photo);
        tvTitle = findViewById(R.id.tv_detail_title);
        tvGenre = findViewById(R.id.tv_detail_genre);
        tvRating = findViewById(R.id.tv_detail_rating);
        tvRuntime = findViewById(R.id.tv_runtime);
        tvDescription = findViewById(R.id.tv_detail_description);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ArrayList<Movie> movies = getIntent().getParcelableArrayListExtra(EXTRA_MOVIE);

        imgCover.setImageResource(movies.get(0).getCover());
        imgPhoto.setImageResource(movies.get(0).getImage());
        tvTitle.setText(movies.get(0).getTitle());
        tvGenre.setText(movies.get(0).getGenre());
        tvRating.setText(movies.get(0).getRating());
        tvRuntime.setText(movies.get(0).getRuntime());
        tvDescription.setText(movies.get(0).getDescription());

    }
}
