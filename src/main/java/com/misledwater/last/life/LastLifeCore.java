package com.misledwater.last.life;

import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.TextFormat;
import com.google.gson.Gson;
import com.misledwater.last.life.command.GiveLifeCommand;
import com.misledwater.last.life.command.LastLifeStartCmd;
import com.misledwater.last.life.event.PlayerJoin;
import com.misledwater.last.life.utils.FileManager;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class LastLifeCore extends PluginBase {

    public static LastLifeCore plugin;
    public HashMap<UUID,FakeLastLifePlayer> allFakeLastLifePlayers;
    public LastLifeServerData serverData;

    public LastLifeServerData getServerData(){
      return serverData;
    }

    public HashMap<UUID,FakeLastLifePlayer> getAllFakeLastLifePlayers(){
        return allFakeLastLifePlayers;
    }

    @Override
    public void onLoad(){
        loadPlayerFiles();
        loadServerData();
    }

    private void loadPlayerFiles(){
        Gson gson = new Gson();
        for(File file : FileManager.getFilesUnderFolder(new File("LastLifeData/Players"))) {
            String fileContent = FileManager.readFile(file);
            try {
                FakeLastLifePlayer fakeLastLifePlayer = gson.fromJson(fileContent, FakeLastLifePlayer.class);
                UUID uuid = fakeLastLifePlayer.getUuid();
                LastLifeCore.getPlugin().getAllFakeLastLifePlayers().put(uuid, fakeLastLifePlayer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void loadServerData(){
      Gson gson = new Gson();
      for(File file : FileManager.getFilesUnderFolder(new File("LastLifeData"))){
        String fileContent = FileManager.readFile(file);
        try {
          LastLifeServerData serverData = gson.fromJson(fileContent, LastLifeServerData.class);
          this.serverData = serverData;
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    
    }

    private void savePlayerFiles(){
        Gson gson = new Gson();
        LastLifeCore.getPlugin().getLogger().info("\n");
        HashMap<UUID, FakeLastLifePlayer> players = new HashMap<>(LastLifeCore.getPlugin().getAllFakeLastLifePlayers());
        for(UUID uuid : players.keySet()) {
            LastLifeCore.getPlugin().getLogger().info("Saving " + uuid + " " + players.get(uuid).getPlayerName() + " player!");
            String toPut = gson.toJson(players.get(uuid), FakeLastLifePlayer.class);
            FileManager.writeFile(new File("LastLifeData/Players/" + uuid.toString() + ".json"), toPut);
        }
        LastLifeCore.getPlugin().getLogger().info("\n");
    }

    private void saveServerData(){
      Gson gson = new Gson();
      LastLifeCore.getPlugin().getLogger().info("\n");
      LastLifeCore.getPlugin().getLogger().info("Saving Server Data!");
      String toPut = gson.toJson(LastLifeServerData.class);
      FileManager.writeFile(new File("LastLifeData/ServerData.json"), toPut);
      LastLifeCore.getPlugin().getLogger().info("\n");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.GREEN + "\n\nTutorial Plugin is on!\n\n");
        registerCommands();
        registerEvents();
        registerTasks();
    }

    public static LastLifeCore getPlugin() {
        return plugin;
    }

    private void registerCommands(){
        SimpleCommandMap commandMap = getServer().getCommandMap();
        commandMap.register("lastlife", new GiveLifeCommand());
        commandMap.register("lastlifestart", new LastLifeStartCmd());
    }

    private void registerEvents(){
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoin(), this);
    }

    private void registerTasks(){

    }

    @Override
    public void onDisable() {
        savePlayerFiles();
        this.getLogger().info(TextFormat.RED + "\n\nTutorial plugin is off!\n\n");
    }
}
