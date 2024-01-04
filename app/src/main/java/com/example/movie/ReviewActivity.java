package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.movie.databinding.ActivityReviewBinding;

public class ReviewActivity extends AppCompatActivity {

    ActivityReviewBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityReviewBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        getAPIDataFromIntent();
    }
    private void getAPIDataFromIntent(){
        Intent intent = getIntent();
        activityMainBinding.textForMovieName.setText(intent.getStringExtra(MainActivity.MOVIE_NAME));
        activityMainBinding.textForMovieReview.setText(intent.getStringExtra(MainActivity.MOVIE_OVERVIEW));
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + intent.getStringExtra(MainActivity.MOVIE_POSTER))
                .into(activityMainBinding.imageForDetails);
        activityMainBinding.ReleaseDateForMovie.setText(intent.getStringExtra(MainActivity.MOVIE_RELEASE_DATE));
        activityMainBinding.voteCount.setText(intent.getStringExtra(MainActivity.MOVIE_VOTE_COUNT));
    }
}