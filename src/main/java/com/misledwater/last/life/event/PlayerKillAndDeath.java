package com.misledwater.last.life.event;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.utils.TextFormat;
import com.misledwater.last.life.FakeLastLifePlayer;
import com.misledwater.last.life.LastLifeCore;

public class PlayerKillAndDeath implements Listener {

    @EventHandler
    public void onKill(EntityDamageByEntityEvent event){
        if(event.isCancelled()) return;
        if(!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)) return;
        if(event.getEntity().isAlive()) return;
        FakeLastLifePlayer damager = LastLifeCore.getPlugin().getAllFakeLastLifePlayers().get(((Player) event.getDamager()).getUniqueId());
        if(damager.getIsBoogeyman()){
            if(LastLifeCore.getPlugin().getServerData().getKeepBoogeymanSecret()){
                ((Player) event.getDamager()).sendTitle(TextFormat.GREEN + "You are cured!");
                damager.setIsBoogeyman(false);
            }
            if(!LastLifeCore.getPlugin().getServerData().getKeepBoogeymanSecret()){
                for(Player player : LastLifeCore.getPlugin().getServer().getOnlinePlayers().values()){
                    player.sendTitle(TextFormat.GREEN + damager.getPlayerName() + " has been cured!");
                    damager.setIsBoogeyman(false);
                }
            }
            damager.setKills(damager.getKills() + 1);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        if(event.isCancelled()) return;
        FakeLastLifePlayer player = LastLifeCore.getPlugin().getAllFakeLastLifePlayers().get(event.getEntity().getUniqueId());
        if(player.getLives() == -1){
            event.setCancelled();
        }
        if(player.getLives() == 1){
            player.setLives(0);
            for(Player onlinePlayer : LastLifeCore.getPlugin().getServer().getOnlinePlayers().values()){
                onlinePlayer.sendTitle(TextFormat.GREEN + event.getEntity().getDisplayName() + " has been cured!");
            }
        }
    }
}
