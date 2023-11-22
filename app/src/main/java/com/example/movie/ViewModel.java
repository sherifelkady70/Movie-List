package com.example.movie;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends androidx.lifecycle.ViewModel {
    MutableLiveData<List<Result>> movieLiveData = new MutableLiveData<>();
    public void getPopularMovies() {
        MovieRequstApi api = ApiClint.getRetrofit().create(MovieRequstApi.class);
        Call<Movies> call = api.getMovies("69d66957eebff9666ea46bd464773cf0");
        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
               if(response.body() != null)
                   movieLiveData.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.d("TAG", t.getMessage());
            }
        });
    }


    public LiveData<List<Result>> getMovieLiveData(){
        return movieLiveData;
    }
}
