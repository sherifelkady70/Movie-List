package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.movie.databinding.ActivityMainBinding;

import java.util.ArrayList;
//import com.example.movie1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    static ActivityMainBinding activityMainBinding;
    static MovieAdapter movieAdapter;
    ViewModel viewModel;
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




    }

    public void prepareRv(){
        movieAdapter = new MovieAdapter();
        activityMainBinding.RV.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        activityMainBinding.RV.setAdapter(movieAdapter);
    }
}