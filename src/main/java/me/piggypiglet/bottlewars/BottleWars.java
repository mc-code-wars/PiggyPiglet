package me.piggypiglet.bottlewars;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public final class BottleWars extends JavaPlugin {
    private static BottleWars instance;
    private Config cfg = new Config(this, getDataFolder().getPath(), "config.yml");

    public static BottleWars getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        final FileConfiguration config = cfg.getConfig();
        config.addDefault("test", 1);
        config.options().copyDefaults(true);
        cfg.save();

        getLogger().info("test1");
    }

    @Override
    public void onDisable() {
        instance = null;

        getLogger().info("test2");
    }
}
