package com.misledwater.last.life.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.misledwater.last.life.LastLifeCore;

public class LastLifeStartCmd extends Command {
  public LastLifeStartCmd() {
    super("lastlifestart");
    this.setDescription("Start Last Life!");
  }
  
  @Override
  public boolean execute(CommandSender sender,String s,String[] args){
    LastLifeCore.getPlugin().getServerData()
  }
}