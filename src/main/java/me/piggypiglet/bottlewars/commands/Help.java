package me.piggypiglet.bottlewars.commands;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.Config;
import me.piggypiglet.bottlewars.handlers.ChatHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.stream.Stream;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class Help {

    public Help(CommandSender sender, Command cmd, String label, String[] args) {
        BottleWars main = BottleWars.getInstance();
        ChatHandler chat = new ChatHandler();
        final FileConfiguration lang = new Config(main.getDataFolder().getPath(), "lang.yml").getConfig();
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            List<String> help = lang.getStringList("help");
            chat.send(sender, String.valueOf(help) ,false, true);
        }
    }
}
