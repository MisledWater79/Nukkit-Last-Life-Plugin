package com.misledwater.last.life;

import java.util.UUID;

public class FakeLastLifePlayer {

    private final UUID uuid;
    private String name;
    private int kills;
    private int deaths;
    private int lives;
    private boolean lastLifePlayer;
    private boolean isBoogeyman;
    

    public FakeLastLifePlayer(UUID uuid,String name,int kills,int deaths,int lives,boolean isPlayer,boolean isBoogeyman){
        this.uuid = uuid;
        this.name = name;
        this.kills = kills;
        this.deaths = deaths;
        this.lives = lives;
        this.lastLifePlayer = isPlayer;
        this.isBoogeyman = isBoogeyman;
    }

    public UUID getUuid(){ return uuid; }

    public String getPlayerName(){
        return name;
    }

    public int getKills() { return kills; }

    public int getDeaths() { return deaths; }

    public int getLives() { return lives; }

    public boolean getLastLifePlayer() { return lastLifePlayer; }

    public boolean getIsBoogeyman() { return isBoogeyman; }

    public void setLives(int lives) { this.lives = lives; }

    public void setKills(int kills) { this.kills = kills; }

    public void setDeaths(int deaths) { this.deaths = deaths; }

    public void setIsBoogeyman(boolean isBoogeyman) { this.isBoogeyman = isBoogeyman; }
}
