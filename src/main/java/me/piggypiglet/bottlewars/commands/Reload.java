package me.piggypiglet.bottlewars.commands;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.Config;
import me.piggypiglet.bottlewars.handlers.ChatHandler;
import org.bukkit.command.CommandSender;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class Reload {

    public Reload(CommandSender sender) {
        BottleWars main = BottleWars.getInstance();
        ChatHandler chat = new ChatHandler();
        if (sender.hasPermission("bottlewars.admin") || sender.hasPermission("bottlewars.reload")) {
            new Config(main.getDataFolder().getPath(), "config.yml").save();
            new Config(main.getDataFolder().getPath(), "lang.yml").save();
            chat.send(sender, "reload complete", true, false);
        }
    }
}
