package com.misledwater.last.life.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import com.misledwater.last.life.LastLifeCore;

public class LastLifeStopCmd extends Command {
    public LastLifeStopCmd() {
        super("lastlifestop");
        this.setDescription("Stop Last Life!");
    }

    @Override
    public boolean execute(CommandSender sender,String s,String[] args){
        if(!LastLifeCore.getPlugin().getServerData().getIsStarted()){
            sender.sendMessage(TextFormat.RED + "The game hasn't started!");
        } else {
            sender.sendMessage(TextFormat.GREEN + "The game has stopped!");
            LastLifeCore.getPlugin().getServerData().setIsStarted(true);
        }
        return false;
    }
}