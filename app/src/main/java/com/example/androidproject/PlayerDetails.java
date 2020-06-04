package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlayerDetails extends AppCompatActivity {
    private TextView town;
    private TextView age;
    private TextView careerPpg;
    private TextView draftYear;
    private TextView championships;
    private TextView mvp;
    private TextView origin;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);

        town = findViewById(R.id.town);
        age = findViewById(R.id.age);
        careerPpg = findViewById(R.id.careerPpg);
        draftYear = findViewById(R.id.draftYear);
        championships = findViewById(R.id.championships);
        mvp = findViewById(R.id.mvp);
        origin = findViewById(R.id.origin);
        image = findViewById(R.id.image1);

        town.setText("His team is based in "+ListAdapter.p.getTown());
        age.setText("He has "+ListAdapter.p.getAge()+" yo");
        careerPpg.setText("He averages "+ListAdapter.p.getCareerPpg()+" ppg");
        draftYear.setText("Has been drafted in "+ListAdapter.p.getDraftYear());
        championships.setText("He won "+ListAdapter.p.getChampionships()+" championships");
        mvp.setText("he won "+ListAdapter.p.getMvp()+" mvp titles");
        origin.setText("He was born in "+ListAdapter.p.getOrigin());


    }
}
