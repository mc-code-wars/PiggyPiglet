package me.piggypiglet.bottlewars.commands;

import me.piggypiglet.bottlewars.handlers.ChatHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.stream.Stream;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class Help {
    private ChatHandler chat;
    public Help(CommandSender sender, Command cmd, String label, String[] args) {
        chat = new ChatHandler();
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            Stream.of(
                    "&ahelp1",
                    "&bhelp2",
                    "&chelp3",
                    "&dhelp4",
                    "&ehelp5"
            ).forEach(msg -> chat.send(sender, msg, false));
        }
    }
}
