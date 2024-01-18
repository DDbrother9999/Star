package net.Star.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.Star.Star;

import java.util.UUID;

@Data
@Getter
@Setter
public class User {

    private Star plugin = Star.getInstance();

    private final UUID uuid;
    private final String name;

    private double Balance;
    private double Kills;
    private double Deaths;

    public User(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;

        loadData();
    }
    private void loadData () {
        var yaml = plugin.getData().getPlayerYaml(uuid.toString());

        Kills = yaml.getOrDefault("kills", 0);
        Deaths = yaml.getOrDefault("Deaths", 0);
        Balance = yaml.getOrDefault("Balance", 0);
        }
    public void saveData() {
        var yaml = plugin.getData().getPlayerYaml(uuid.toString());

        yaml.set("name", getName());
        yaml.set("kills", Kills);
        yaml.set("deaths", Deaths);
        yaml.set("Balance", Balance);
    }
}


