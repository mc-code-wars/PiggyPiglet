package me.piggypiglet.bottlewars.commands;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.handlers.ChatHandler;
import org.bukkit.command.CommandSender;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class Debug {
    public Debug(CommandSender sender) {
        BottleWars main = BottleWars.getInstance();
        ChatHandler chat = new ChatHandler();

        chat.send(sender, "&7getPath&b " + main.getDataFolder().getPath(), false, false);
        chat.send(sender, "&7getAbsolutePath&b " + main.getDataFolder().getAbsolutePath(), false, false);
        try {
            chat.send(sender, "&7getCanonicalPath &b" + main.getDataFolder().getCanonicalPath(), false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
