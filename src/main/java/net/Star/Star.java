package net.Star;

import co.aikar.commands.PaperCommandManager;

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

import java.util.Objects;

public class Star extends JavaPlugin implements Listener {
    private PaperCommandManager commandManager;
    private UserManager manager;
    @Override
    public void onEnable() {
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

}