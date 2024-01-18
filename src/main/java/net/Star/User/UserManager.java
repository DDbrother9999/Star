package net.Star.User;

import lombok.Getter;
import net.Star.Star;
import net.Star.Utils.Tasks;
import net.Star.Utils.TypeCallback;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;


@Getter
public class UserManager {

    public UserManager() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Star.getInstance(), () -> {
            for (var user : users.values()) {
                user.saveData();
            }
        }, 300 * 20L, 300 * 20L);
    }

    private final ConcurrentHashMap<UUID, User> users = new ConcurrentHashMap<>();

    public User getOffline(UUID uuid, String name) {
        return new User(uuid, name);
    }

    public User getOffline(OfflinePlayer player) {
        if (player.isOnline()) {
            return get(player.getUniqueId());
        }

        return getOffline(player.getUniqueId(), player.getName());
    }

    public void getOffline(UUID uuid, String name, TypeCallback<User> callback) {
        Tasks.runAsync(() -> {
            var user = new User(uuid, name);
            callback.callback(user);
        });
    }

    public void fetch(UUID uuid, TypeCallback<User> callback) {
        Player player = Bukkit.getPlayer(uuid);

        if (player != null) {
            callback.callback(get(player));
            return;
        }

        Tasks.runAsync(() -> {
            var user = users.get(uuid);
            if (user == null) {
                user = new User(uuid, Bukkit.getOfflinePlayer(uuid).getName());
                users.put(uuid, user);
            }

            User finalUser = user;
            Tasks.runSync(() -> callback.callback(finalUser));
        });
    }

    public User create(UUID uuid, String name) {
        User user = new User(uuid, name);
        users.put(uuid, user);
        return user;
    }

    public User get(Player player) {
        return users.get(player.getUniqueId());
    }

    public User get(UUID uuid) {
        return users.get(uuid);
    }

    public void destroy(User user, boolean save) {
        if (save) {
            user.saveData();
        }

        users.remove(user.getUuid());
    }
}
