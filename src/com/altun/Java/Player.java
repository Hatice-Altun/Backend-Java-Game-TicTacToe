package com.altun.Java;

public class Player {

    // Attributes
    private String name;
    private String token;
    private int score;

    // Constructor
    public Player(String name, String token){
        this.name = name;
        this.token = token;
        this.score = 0;
    }

    // Methodes
    public int getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

    public String getToken(){
        return this.token;
    }

    public void setScore(int extraPoints){
        score = score + extraPoints;
    }
}
