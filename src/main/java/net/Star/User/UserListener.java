package net.Star.User;


import net.Star.Star;
import net.Star.User.UserManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;


public class UserListener implements Listener {
    private final Star plugin;
    public UserListener(Star plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        final var userManager = plugin.getUserManager();
        final var user = userManager.get(event.getPlayer());

        if (user == null) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, Component.text("Your User data was not loaded at the pre login stage, please try logging in again.", NamedTextColor.RED));
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        final var userManager = plugin.getUserManager();
        final var user = userManager.get(event.getPlayer());
        final var player = event.getPlayer();

        if (user == null) {
            player.kick(Component.text("Your User data was not loaded at the pre login stage, please try logging in again.", NamedTextColor.RED));
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        final var player = event.getPlayer();
        final var userManager = plugin.getUserManager();
        final var user = userManager.get(player);
        final var uuid = player.getUniqueId();

        Bukkit.getScheduler().runTaskAsynchronously(Star.getInstance(), () -> {
            final var player1 = Bukkit.getPlayer(uuid);

            if (user == null) {
                return;
            }

            if (player1 == null) {
                userManager.destroy(user, true);
            }
        });
    }

}
