package com.example.movie;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClint {
    static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        retrofit= new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
