package me.piggypiglet.bottlewars;

import me.piggypiglet.bottlewars.handlers.CommandHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.Stream;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public final class BottleWars extends JavaPlugin {
    private static BottleWars instance;
    private Config cfg() {
        return new Config(getDataFolder().getPath(), "config.yml");
    }
    private void lang() {
        new Config(getDataFolder().getPath(), "lang.yml");
    }

    public static BottleWars getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        getCommand("bw").setExecutor(new CommandHandler());

        cfg();
        lang();

        final FileConfiguration config = cfg().getConfig();
        config.addDefault("test", 1);
        config.options().copyDefaults(true);
        cfg().save();

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
