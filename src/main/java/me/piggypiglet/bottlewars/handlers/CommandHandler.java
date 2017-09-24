package me.piggypiglet.bottlewars.handlers;

import me.piggypiglet.bottlewars.commands.CreateLobby;
import me.piggypiglet.bottlewars.commands.Debug;
import me.piggypiglet.bottlewars.commands.Help;
import me.piggypiglet.bottlewars.commands.Reload;
import me.piggypiglet.bottlewars.enums.Commands;
import org.apache.commons.lang3.EnumUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

import static me.piggypiglet.bottlewars.enums.Messages.*;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class CommandHandler implements CommandExecutor {
    private ChatHandler chat;

    public CommandHandler() {
        chat = new ChatHandler();
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("bw")) {
            if (args.length == 1 && Arrays.stream(Commands.values()).noneMatch((cmdd) -> cmdd.name().equalsIgnoreCase(args[0]))) {
                chat.sendError(sender, UNKNOWNSUB, true, false);
            } else if (args.length == 0) {
                new Help(sender);
            } else {
                switch (args[0]) {
                    case "help":
                        new Help(sender);
                        break;
                    case "reload":
                        new Reload(sender);
                        break;
                    case "createlobby":
                        new CreateLobby(sender);
                        break;
                    case "debug":
                        new Debug(sender);
                        break;
                }
            }
        }
        return true;
    }
}
