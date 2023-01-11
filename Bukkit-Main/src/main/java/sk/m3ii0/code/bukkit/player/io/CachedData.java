package sk.m3ii0.code.bukkit.player.io;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import sk.m3ii0.code.bukkit.internal.UpFantasy;
import sk.m3ii0.code.bukkit.player.FantasyPlayer;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class CachedData {

    // Create class instance
    public static CachedData read(UUID uuid) {

        // Create cached data instance
        CachedData data = new CachedData(uuid);

        // File name
        String fileName = uuid + ".yml";

        // Configuration file
        File configFile = new File(UpFantasy.get().getDataFolder(), fileName);

        // Create player file if not exists
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Config
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        return data;
    }

    // Write data to file
    public static void write(FantasyPlayer cachedData) {



    }

    // Private constructor
    private CachedData(UUID uuid) {

    }

}
