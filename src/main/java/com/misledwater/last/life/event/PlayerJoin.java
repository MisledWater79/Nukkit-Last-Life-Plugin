package com.misledwater.last.life.event;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.TextFormat;
import com.misledwater.last.life.FakeLastLifePlayer;
import com.misledwater.last.life.LastLifeCore;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setDisplayName(TextFormat.DARK_PURPLE + player.getName());
        FakeLastLifePlayer fakeLastLifePlayer = new FakeLastLifePlayer(player.getUniqueId(),player.getName(),0,0,-1);
        LastLifeCore.getPlugin().getAllFakeLastLifePlayers().putIfAbsent(player.getUniqueId(),fakeLastLifePlayer);
        event.setJoinMessage(TextFormat.DARK_PURPLE + player.getName() + " has joined the server!");
    }
}
