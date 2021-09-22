package com.misledwater.last.life;

import java.util.UUID;

public class FakeLastLifePlayer {

    private final UUID uuid;
    private String name;
    private int kills;
    private int deaths;
    private int lives;

    public FakeLastLifePlayer(UUID uuid,String name,int kills,int deaths,int lives){
        this.uuid = uuid;
        this.name = name;
        this.kills = kills;
        this.deaths = deaths;
        this.lives = lives;
    }

    public UUID getUuid(){ return uuid; }

    public String getPlayerName(){
        return name;
    }

    public int getLives() { return lives; }

    public void setLives(int lives) { this.lives = lives; }
}
