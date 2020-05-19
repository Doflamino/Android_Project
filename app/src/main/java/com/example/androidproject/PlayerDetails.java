package com.example.androidproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerDetails extends AppCompatActivity {
    private String town;
    private int age;
    private int careerPpg;
    private int draftYear;
    private int championships;
    private int mvp;
    private String origin;

    public String getTown() {
        return town;
    }

    public int getAge() {
        return age;
    }

    public int getCareerPpg() {
        return careerPpg;
    }

    public int getDraftYear() {
        return draftYear;
    }

    public int getChampionships() {
        return championships;
    }

    public int getMvp() {
        return mvp;
    }

    public String getOrigin() {
        return origin;
    }
}

