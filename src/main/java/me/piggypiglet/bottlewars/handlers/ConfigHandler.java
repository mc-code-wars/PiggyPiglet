package me.piggypiglet.bottlewars.handlers;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.Config;
import me.piggypiglet.bottlewars.enums.Messages;
import org.bukkit.configuration.file.FileConfiguration;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class ConfigHandler {
    private Config config;

    public ConfigHandler() {
        BottleWars main = BottleWars.getInstance();
        config = new Config(main.getDataFolder().getPath(), "lang.yml");
    }
    public String getMessages(Messages msg) {
        final FileConfiguration cfg = config.getConfig();
        return cfg.getString(msg.toString().toLowerCase()) + "&r";
    }
}