package com.example.androidproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlayerApi {

    @GET("/PDybala10/WEsiea/posts")
    Call<List<PlayerDetails>> getRestResponse();

}