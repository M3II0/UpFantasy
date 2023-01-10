package sk.m3ii0.code.bukkit.player.io;

import sk.m3ii0.code.bukkit.player.FantasyPlayer;

import java.util.UUID;

public class CachedData {

    // Create class instance
    public static CachedData read(UUID uuid) {
        return new CachedData(uuid);
    }

    // Write data to file
    public static void write(FantasyPlayer cachedData) {

    }

    // Private constructor
    private CachedData(UUID uuid) {

    }

}
