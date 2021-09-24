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
    if(LastLifeCore.getPlugn().getServerData().getIsStarted() == true){
      sender.sendMessage(TextFormat.RED + "The game has already started!");
    } else {
      sender.sendMessage(TextFormat.GREEN + "The game has started!");
      LastLifeCore.getPlugin().getServerData().setIsStarted(true);
    }
    return false;
  }
}