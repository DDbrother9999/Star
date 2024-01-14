package net.Star.Utils.Storage;

import net.Star.Star;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

public class Data {

    public Yaml getPlayerYaml(String uuid) {
        Star plugin = Star.getInstance();
        return new Yaml(plugin.getDataFolder().getAbsolutePath() + File.separator + "data" + File.separator + "players" + File.separator + uuid + ".yml");
    }

    public Yaml getPlayerYaml(Player player) {
        Star plugin = Star.getInstance();
        return new Yaml(plugin.getDataFolder().getAbsolutePath() + File.separator + "data" + File.separator + "players" + File.separator + player.getUniqueId() + ".yml");
    }

    public Yaml getOfflinePlayerYaml(String uuid) {
        Star plugin = Star.getInstance();
        return new Yaml(plugin.getDataFolder().getAbsolutePath() + File.separator + "data" + File.separator + "players" + File.separator + uuid + ".yml");
    }

    public void setup() {
        File star = new File(Star.getInstance().getDataFolder().getAbsolutePath());
        File data = new File(Star.getInstance().getDataFolder().getAbsolutePath() + File.separator + "data");
        File players = new File(Star.getInstance().getDataFolder().getAbsolutePath() + File.separator + "data" + File.separator + "players");

        if (!star.exists())
            star.mkdir();

        if (!data.exists())
            data.mkdir();

        if (!players.exists())
            players.mkdir();

    }

    public Yaml getStorageFile() {
        Star plugin = Star.getInstance();
        return new Yaml(plugin.getDataFolder().getAbsolutePath() + File.separator + "data" + File.separator + "data.yml");
    }
}