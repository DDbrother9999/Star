package net.Star.User;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class DataManager {
    private final Map<String, User> playerDataMap;
    private final FileConfiguration config;

    public DataManager(FileConfiguration config) {
        this.playerDataMap = new HashMap<>();
        this.config = config;
    }

    public User getPlayerData(String playerName) {
        return playerDataMap.computeIfAbsent(playerName, k -> {
            User newData = new User();
            savePlayerData(playerName, newData);
            return newData;
        });
    }

    public void savePlayerData(String playerName, User data) {

        Player player = Bukkit.getPlayer(playerName);
        config.set("players." + player.getUniqueId() + ".kills", data.getKills());
        config.set("players." + player.getUniqueId() + ".deaths", data.getDeaths());
        config.set("players." + player.getUniqueId() + ".money", data.getBalance());
    }

    public Map<String, User> getPlayerDataMap() {
        return playerDataMap;
    }
}
