package net.Star.User;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
public class UserManager {

    public UserManager() {

    }

    private final HashMap<UUID, User> users = new HashMap<>();

    public User create (UUID uuid, String name){
        User user = new User(uuid, name);
        users.put(uuid, user);
        return user;
    }

}
