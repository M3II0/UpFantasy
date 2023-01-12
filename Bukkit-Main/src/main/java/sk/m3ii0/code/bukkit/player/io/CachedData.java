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

        // Check if player has any login before
        boolean firstLogin = !config.contains("Logins");

        // Set first login or set total logins (And LastLogin)
        if (firstLogin) {

            // Set total login
            data.setTotalLogin(0);

            // Set value
            data.setLastLogin("Never");

        } else {

            // Get player's logins
            int totalLogins = config.getInt("Logins");

            // Get player's last login
            String lastLogin = config.getString("LastLogin");

            // Set player's logins
            data.setTotalLogin(totalLogins);

            // Set player's last login
            data.setLastLogin(lastLogin);

        }

        return data;
    }

    // Write data to file
    public static void write(FantasyPlayer fantasyPlayer) {

        // File name
        String fileName = fantasyPlayer.getPlayer().getUniqueId() + ".yml";

        // Configuration file
        File configFile = new File(UpFantasy.get().getDataFolder(), fileName);

        // Get config file
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        // Write total logins to file
        config.set("Logins", fantasyPlayer.getLogins());

        // Write player last login
        config.set("LastLogin", fantasyPlayer.getLastLogin());

        // Save to file
        try {
            config.save(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // UUID of player
    private final UUID uuid;

    // Last login value
    private String lastLogin;

    // Total login value
    private int totalLogin;

    // Private constructor
    private CachedData(UUID uuid) {

        // Set uuid as final value
        this.uuid = uuid;

    }

    // Get player's uuid
    public UUID getUuid() {
        return uuid;
    }

    // Set last login value
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    // Set total login value
    public void setTotalLogin(int totalLogin) {
        this.totalLogin = totalLogin;
    }

    // Get total login value
    public int getTotalLogin() {
        return totalLogin;
    }

    // Get last login value
    public String getLastLogin() {
        return lastLogin;
    }

}
