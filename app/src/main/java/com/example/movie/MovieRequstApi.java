package com.example.movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieRequstApi {
    @GET("popular?")
    Call<Movies> getMovies(@Query("api_key") String api_key);
}
