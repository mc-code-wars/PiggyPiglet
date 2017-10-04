package me.piggypiglet.bottlewars.handlers;

import me.piggypiglet.bottlewars.BottleWars;
import me.piggypiglet.bottlewars.Config;
import org.bukkit.configuration.file.FileConfiguration;

// ------------------------------
// Copyright (c) PiggyPiglet 2017
// https://www.piggypiglet.me
// ------------------------------
public class DataSaving {
    private BottleWars main = BottleWars.getInstance();
    private final FileConfiguration config = new Config(main.getDataFolder().getPath(), "config.yml").getConfig();

    public void saveString(String str) {
        switch (config.getString("storage-method", "yaml").toLowerCase()) {
            case "mysql":
                new MySQL(config);
                break;
            case "json":
                new JSON(config);
                break;
            case "mariadb":
                new MySQL(config);
                break;
            case "mongodb":
                new MongoDB(config);
                break;
            case "yaml":
                new YAML(config);
                break;
            case "h2":
                new H2(config);
                break;
            case "sqllite":
                new H2(config);
                break;
            case "postgresql":
                new PostgreSQL(config);
                break;
        }
    }
}
