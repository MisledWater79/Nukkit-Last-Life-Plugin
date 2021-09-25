package com.misledwater.last.life;

public class LastLifeServerData {
  private boolean isStarted = false;
  private boolean showNameColor = true;
  private boolean announceRedNames = true;
  private boolean keepBoogeymanSecret = true;
  private int maxLives = 6;
  private int minLives = 2;
  private int maxBoogeymen = 2;
  private int minBoogeymen = 1;
  
  public boolean getIsStarted(){return isStarted;}
  public boolean getShowNameColor(){return showNameColor;}
  public boolean getAnnounceRedNames(){return announceRedNames;}
  public boolean getKeepBoogeymanSecret(){return keepBoogeymanSecret;}
  
  public void setIsStarted(boolean isStarted){this.isStarted = isStarted;}
}