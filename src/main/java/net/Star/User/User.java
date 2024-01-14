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

     load();
    }
    private void load() {
        var yaml = plugin.getData().getPlayerYaml(uuid.toString());
    }
}
