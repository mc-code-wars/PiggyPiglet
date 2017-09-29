package me.piggypiglet.bottlewars.handlers;

import me.piggypiglet.bottlewars.enums.Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import static me.piggypiglet.bottlewars.enums.Messages.*;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class ChatHandler {
    private ConfigHandler config;

    public ChatHandler() {
        config = new ConfigHandler();
    }
    public void send(CommandSender sender, String str, Boolean prefix, Boolean list) {
        String msg1 = prefix ? config.getMessages(PREFIX) + str : str;
        String msg = list ? msg1.replace("[", "").replace("]", "").replace(", ", "\n") : msg1;
        sender.sendMessage(cc(msg));
    }
    public void sendError(CommandSender sender, Messages error, Boolean prefix, Boolean list) {
        String err1 = prefix ? config.getMessages(PREFIX) + config.getMessages(error) : config.getMessages(error);
        String err = list ? err1.replace("[", "").replace("]", "").replace(", ", "\n") : err1;
        sender.sendMessage(cc(err));
    }
    private String cc(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}