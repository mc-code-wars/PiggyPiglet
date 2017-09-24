package me.piggypiglet.bottlewars.commands;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.Config;
import me.piggypiglet.bottlewars.handlers.ChatHandler;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static me.piggypiglet.bottlewars.enums.Messages.*;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class CreateLobby {
    public CreateLobby(CommandSender sender) {
        BottleWars main = BottleWars.getInstance();
        ChatHandler chat = new ChatHandler();
        final FileConfiguration config = new Config(main.getDataFolder().getPath(), "config.yml").getConfig();
        if (sender.hasPermission("bottlewars.admin") || sender.hasPermission("bottlewars.createlobby")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                String item;

                if (Arrays.stream(Material.values()).anyMatch((mat) -> mat.name().equalsIgnoreCase(config.getString("select-item")))) {
                    item = config.getString("select-item");
                } else {
                    item = "STICK";
                    chat.sendError(sender, UNKNOWNMAT, true, false);
                }
                ItemStack wand = new ItemStack(Material.valueOf(item), 1);
                ItemMeta mwand = wand.getItemMeta();
                mwand.setDisplayName(chat.cc(config.getString("select-item-name", "&bLobby Maker")));
                wand.setItemMeta(mwand);

                p.getInventory().addItem(wand);
            } else {
                chat.sendError(sender, NOTPLAYER, true, false);
            }
        }
    }
}