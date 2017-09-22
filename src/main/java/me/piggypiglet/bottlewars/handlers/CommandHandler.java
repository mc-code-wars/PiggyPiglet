package me.piggypiglet.bottlewars.handlers;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.Config;
import me.piggypiglet.bottlewars.commands.Help;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class CommandHandler implements CommandExecutor {
    private BottleWars main;
    private ChatHandler chat;

    public CommandHandler() {
        main = BottleWars.getInstance();
        chat = new ChatHandler();
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final FileConfiguration lang = new Config(main.getDataFolder().getPath(), "lang.yml").getConfig();
        if (label.equalsIgnoreCase("bw")) {
            new Help(sender, cmd, label, args);
        }
        return true;
    }
}
