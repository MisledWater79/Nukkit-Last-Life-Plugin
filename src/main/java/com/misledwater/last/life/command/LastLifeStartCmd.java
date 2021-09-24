package com.misledwater.last.life.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;

public class LastLifeStartCmd extends Command {
  public LastLifeStartCmd() {
    super("giveLife");
    this.setDescription("Give one of your lives to another player!");
    this.setAliases(new String[]{"gl"});
    commandParameters.clear();
  }
  
  @Override
  public boolean execute(CommandSender sender, String[] args){
    return false;
  }
}