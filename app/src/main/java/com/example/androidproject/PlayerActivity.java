package com.example.androidproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {
    private TextView town;
    private TextView age;
    private TextView careerPpg;
    private TextView draftYear;
    private TextView championships;
    private TextView mvp;
    private TextView origin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);

       /* town = findViewById(R.id.town);
        age = findViewById(R.id.age);
        careerPpg = findViewById(R.id.careerPpg);
        draftYear = findViewById(R.id.draftYear);
        championships = findViewById(R.id.championships);
        mvp = findViewById(R.id.mvp);
        origin = findViewById(R.id.origin);

        town.setText(ListAdapter.p.getTown());
        age.setText(ListAdapter.p.getAge()+" yo");
        //detail_itemImage.setText(ItemsAdapter.m.getTemperature());
        careerPpg.setText(ListAdapter.p.getCareerPpg()+" ppg");
        draftYear.setText(ListAdapter.p.getDraftYear());
        championships.setText(ListAdapter.p.getChampionships()+" titles");
        mvp.setText(ListAdapter.p.getMvp()+" titles");
        origin.setText(ListAdapter.p.getOrigin());*/



    }
}
