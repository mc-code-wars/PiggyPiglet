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
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static me.piggypiglet.bottlewars.enums.Messages.*;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class CommandHandler implements CommandExecutor, TabCompleter {
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
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("bw")) {
            if (args.length == 1) {
                ArrayList<String> sub = new ArrayList<>();
                if (args[0].equals("")) {
                    for (Commands commd : Commands.values()) {
                        sub.add(commd.name().toLowerCase());
                    }
                } else {
                    for (Commands commd : Commands.values()) {
                        if (commd.name().toLowerCase().startsWith(args[0])) {
                            sub.add(commd.name().toLowerCase());
                        }
                    }
                }
                Collections.sort(sub);
                return sub;
            }
        }
        return null;
    }
}
