package net.Star.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

@CommandAlias("test")
public class TestCommand extends BaseCommand{

    @Subcommand("help")
    public void onTestHelp(Player player){
        player.sendMessage(Component.text("Hello, " + player + "!" + "You've done the command /test help"));
    }

}
