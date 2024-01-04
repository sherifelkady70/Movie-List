package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.movie.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//import com.example.movie1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    static ActivityMainBinding activityMainBinding;
    static MovieAdapter movieAdapter;
    List<Result> results;
    ViewModel viewModel;

    static final String MOVIE_NAME = "NAMEFORMOVIE";
    static final String MOVIE_POSTER = "POSTERFORMOVIE";
    static final String MOVIE_OVERVIEW = "OVERVIEWFORMOVIE";
    static final String MOVIE_RELEASE_DATE = "RELEASEDATEFORMOVIE";
    static final String MOVIE_VOTE_COUNT = "VOTEDATEFORMOVIE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        prepareRv();

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getPopularMovies();
        viewModel.getMovieLiveData().observe(this, results ->
                movieAdapter.setList((ArrayList<Result>) results));



        movieAdapter.movieClickListener = new MovieAdapter.SetOnMovieClickListener() {
            @Override
            public void setOnClickListener(Result result, int position) {
                makeDetailsIntent(position);
            }
        };

    }

    public void prepareRv(){
        movieAdapter = new MovieAdapter();
        activityMainBinding.RV.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        activityMainBinding.RV.setAdapter(movieAdapter);
    }

    public void makeDetailsIntent(int position){
        String movieName = Objects.requireNonNull(viewModel.getMovieLiveData().getValue())
                .get(position).getOriginal_title();
        String movieOverView = viewModel.getMovieLiveData().getValue().get(position).getOverview();
        String moviePoster = viewModel.getMovieLiveData().getValue().get(position).getPoster_path();
        double movieVoteCount = viewModel.getMovieLiveData().getValue().get(position).getVote_average();
        String movieVote = String.valueOf(movieVoteCount);
        String movieReleaseDate = viewModel.getMovieLiveData().getValue().get(position).getRelease_date();

        Intent intent = new Intent(this, ReviewActivity.class);
        intent.putExtra(MOVIE_NAME,movieName);
        intent.putExtra(MOVIE_OVERVIEW,movieOverView);
        intent.putExtra(MOVIE_POSTER,moviePoster);
        intent.putExtra(MOVIE_RELEASE_DATE,movieReleaseDate);
        intent.putExtra(MOVIE_VOTE_COUNT,movieVote);
        startActivity(intent);
    }
}