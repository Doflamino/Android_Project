package com.example.androidproject;

public class Player {
    private String name;
    private int height;
    private String team;
    private String position;
    private int image;

    public Player(String name, int height, String team, String position, int image) {
        this.name = name;
        this.height = height;
        this.team = team;
        this.position = position;
        this.image = image;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPosition(String post) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }
}
