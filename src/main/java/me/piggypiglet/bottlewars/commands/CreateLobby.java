package me.piggypiglet.bottlewars.commands;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.Config;
import me.piggypiglet.bottlewars.handlers.ChatHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.piggypiglet.bottlewars.enums.Messages.*;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class CreateLobby {
    public CreateLobby(CommandSender sender, String[] args) {
        BottleWars main = BottleWars.getInstance();
        ChatHandler chat = new ChatHandler();
        final FileConfiguration config = new Config(main.getDataFolder().getPath(), "config.yml").getConfig();
        if (sender.hasPermission("bottlewars.admin") || sender.hasPermission("bottlewars.createlobby")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 1 || args.length == 2) {
                    chat.sendError(p, NOTENOUGHARGS, true, false);
                } else if (args.length == 3) {
                    if (args[01])
                }
            } else {
                chat.sendError(sender, NOTPLAYER, true, false);
            }
        }
    }
}