package me.piggypiglet.bottlewars;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class Config {
    private File file;
    private FileConfiguration fileConfig;

    public Config(JavaPlugin main, String path, String fileName) {
        file = new File(path, fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            main.saveResource(fileName, false);
        }
        FileConfiguration filesConfig = new YamlConfiguration();
        try {
            filesConfig.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileConfig = filesConfig;
    }

    public FileConfiguration getConfig(){
        return fileConfig;
    }
    public void save() {
        try {
            fileConfig.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
