package me.piggypiglet.bottlewars.commands;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.Config;
import me.piggypiglet.bottlewars.handlers.ChatHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class Help {
    public Help(CommandSender sender) {
        BottleWars main = BottleWars.getInstance();
        ChatHandler chat = new ChatHandler();
        if (sender.hasPermission("bottlewars.use") || sender.hasPermission("bottlewars.help")) {
            final FileConfiguration lang = new Config(main.getDataFolder().getPath(), "lang.yml").getConfig();
            List<String> help = lang.getStringList("help");
            chat.send(sender, String.valueOf(help), false, true);
        }
    }
}
