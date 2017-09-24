package me.piggypiglet.bottlewars;

import me.piggypiglet.bottlewars.handlers.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.stream.Stream;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public final class BottleWars extends JavaPlugin {
    private static BottleWars instance;

    public static BottleWars getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;

        getCommand("bw").setExecutor(new CommandHandler());

        new Config(getDataFolder().getPath(), "config.yml");
        new Config(getDataFolder().getPath(), "lang.yml");
        new Config(getDataFolder().getPath(), "guis/test.yml");

        Stream.of(
                "---- BottleWars ----",
                "Config Loaded",
                "Language Config Loaded",
                "BottleWars by PiggyPiglet, version " + getDescription().getVersion(),
                "--------------------"
        ).forEach(getLogger()::info);
    }
    @Override
    public void onDisable() {
        instance = null;

        Stream.of(
                "---- BottleWars ----",
                "BottleWars is now disabled",
                "BottleWars by PiggyPiglet, version " + getDescription().getVersion(),
                "--------------------"
        ).forEach(getLogger()::info);
    }
}
