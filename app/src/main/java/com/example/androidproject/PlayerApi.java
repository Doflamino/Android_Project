package com.example.androidproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlayerApi {

    @GET("/Doflamino/Android_Project/posts")
    Call<List<Player>> getRestResponse();

}