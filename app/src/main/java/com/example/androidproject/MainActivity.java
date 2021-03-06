package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static Context CONTEXT;

    private static final String BASE_URL= "https://my-json-server.typicode.com/";
    private ArrayList<Player> itemsList = new ArrayList<Player>();
    public static List<Player> playerDetailsList = new ArrayList<Player>();
    private SharedPreferences preferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.CONTEXT = this;
        preferences = getApplicationContext().getSharedPreferences(PlayerPreference.PREFERENCE_NAME,MODE_PRIVATE);
        gson = new GsonBuilder()
                .setLenient()
                .create();
        List<Player> listPlayerPreferences = getDataPreferences();
        if(listPlayerPreferences != null){
            playerDetailsList = listPlayerPreferences;

            setData(playerDetailsList);
        } else {

            apiCall();
        }


    }

    private List<Player> getDataPreferences() {
        String jsonOffre =  preferences.getString(PlayerPreference.PREFERENCE_KEY,null);

        if(jsonOffre == null) {
            return null;
        }
        else {
            Type type = new TypeToken<List<Player>>() {
            }.getType();
            return gson.fromJson(jsonOffre, type);
        }
    }

    private void savePreferences(List<Player> offreList) {
        String jsonString = gson.toJson(offreList);

        preferences
                .edit()
                .putString(PlayerPreference.PREFERENCE_KEY, jsonString)
                .apply();
        Toast.makeText(MainActivity.CONTEXT, " list saved", Toast.LENGTH_SHORT).show();
    }
    private void apiCall() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PlayerApi playerApi = retrofit.create(PlayerApi.class);

        Call<List<Player>> call = playerApi.getRestResponse();
        call.enqueue(new Callback<List<Player>>() {
           @Override
           public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
               if (response.isSuccessful() && response.body() != null){
                   playerDetailsList = response.body();



                   savePreferences(playerDetailsList);

                  setData(playerDetailsList);

                   Toast.makeText(getApplicationContext(), "success",Toast.LENGTH_SHORT).show();
               }else{
                   showError();
               }

           }

           @Override
           public void onFailure(Call<List<Player>> call, Throwable t) {
               showError();

           }
       });

    }

    private void showError() {
        Toast.makeText(getApplicationContext(),"API error", Toast.LENGTH_SHORT).show();
    }

    private void setData(List<Player> lists){

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ListAdapter(lists);
        recyclerView.setAdapter(adapter);

    }




}
