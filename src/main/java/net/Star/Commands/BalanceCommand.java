package net.Star.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

@CommandAlias("bal")
public class BalanceCommand extends BaseCommand{

    @Subcommand("add")
    public void onAddBalance(Player player, Integer balance){

    }

    @Subcommand("remove")
    public void onRemoveBalance(Player player, Integer balance){

    }

    @Subcommand("set")
    public void onSetBalance(Player player, Integer balance){

    }

}
