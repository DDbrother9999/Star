package net.Star;

import co.aikar.commands.PaperCommandManager;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.Star.Commands.BalanceCommand;
import net.Star.User.UserManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.Star.Commands.TestCommand;
import net.Star.Utils.Storage.Data;

import java.util.Objects;

@Getter
@Setter
public class Star extends JavaPlugin implements Listener {

    private static Star instance;
    private PaperCommandManager commandManager;
    private UserManager userManager;

    private Data data = new Data();
    @Override
    public void onEnable() {

        instance = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        commandManager = new PaperCommandManager(this);

        registerCommands();
    }
    @Override
    public void onDisable(){

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Hello, " + event.getPlayer().getName() + "!"));
    }
    private void registerCommands() {
        commandManager.registerCommand(new TestCommand());
        commandManager.registerCommand(new BalanceCommand());
    }

    public static Star getInstance() {
        return instance;
    }

}