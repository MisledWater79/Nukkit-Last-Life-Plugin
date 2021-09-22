package com.misledwater.last.life.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.utils.TextFormat;
import com.misledwater.last.life.FakeLastLifePlayer;
import com.misledwater.last.life.LastLifeCore;

import java.util.HashMap;
import java.util.UUID;

public class GiveLifeCommand extends Command {

    public GiveLifeCommand(){
        super("giveLife");
        this.setDescription("Give one of your lives to another player!");
        this.setAliases(new String[]{"gl"});
        commandParameters.clear();
        commandParameters.put("default", new CommandParameter[]{
                new CommandParameter("Player Name", CommandParamType.TARGET, false)
        });
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args){
        if(!(sender instanceof Player)){
            if(args.length == 0){
                sender.sendMessage(TextFormat.RED + "Please identify a player to push!");
                return false;
            }

            Player playerToGive = LastLifeCore.getPlugin().getServer().getPlayer(args[0]);
            if(playerToGive == null){
                sender.sendMessage(TextFormat.RED + "That is not a real player!");
                return false;
            }

            HashMap<UUID, FakeLastLifePlayer> fakeLastLifePlayer = LastLifeCore.getPlugin().getAllFakeLastLifePlayers();
            FakeLastLifePlayer giver = fakeLastLifePlayer.get(sender.getServer().getPlayer(sender.getName()).getUniqueId());
            FakeLastLifePlayer taker = fakeLastLifePlayer.get(playerToGive.getUniqueId());

            if(giver.getLives() >= 1){
                giver.setLives(giver.getLives()-1);
                sender.sendMessgae(TextFormat.RED + "You have given one of your lives to " + taker.getName());
                taker.setLives(taker.getLives()+1);
                playerToGive.sendMessage(TextFormat.GREEN + "You have received a life from " + giver.getName());
            }
        }
        return false;
    }
}
