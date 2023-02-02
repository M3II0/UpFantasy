package sk.m3ii0.code.bukkit.internal;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import sk.m3ii0.code.bukkit.listeners.ListenerManager;
import sk.m3ii0.code.bukkit.player.FantasyPlayer;
import sk.m3ii0.code.bukkit.spi.PacketManager;
import sk.m3ii0.code.bukkit.utils.Version;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.UUID;

public class UpFantasy implements Listener {

    // Class instance
    private static UpFantasy instance;

    // Hashmap for Player-FantasyPlayer
    private final Map<UUID, FantasyPlayer> players = new HashMap<>();

    // Plugin instance
    private final Plugin plugin;

    // Configuration files
    private FileConfiguration config;

    // Player - Data folder
    private File dataFolder;

    // Server info
    private Version version;

    // Packet version
    private PacketManager packetManager;

    // Get instance from static access
    public static UpFantasy get() {
        return instance;
    }

    // Constructor
    public UpFantasy(Plugin plugin) {

        // Register plugin
        this.plugin = plugin;

        // At finish, register instance
        instance = this;

    }

    // Load logic
    public UpFantasy load() {

        // Create configuration files
        plugin.saveResource("config.yml", false);

        // Load configuration files
        File config = new File(plugin.getDataFolder(), "config.yml");

        // Load data folder
        dataFolder = new File(plugin.getDataFolder(), "playerData");

        // Create data folder if not exists
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        // Create FileConfiguration instance
        this.config = YamlConfiguration.loadConfiguration(config);

        // Check if plugin can be enabled
        boolean loadPermission = this.config.getBoolean("LoadPlugin");

        // Load
        if (loadPermission) {

            // Load server info
            version = Version.getServerVersion();

            // Enable checks
            boolean supportedVersion = version != null && version.getRaw() > 18;

            // Load message
            Bukkit.getConsoleSender().sendMessage("\n" +
                    "\n" +
                    "§fLoading §3UpFantasy §fby M3II0\n" +
                    "\n" +
                    "§7Version: §3" + ((version != null)? version.getRaw() : "null") + "\n" +
                    "§7Nms: §3" + ((version != null)? version.getPacketVersion() : "null") + "\n" +
                    "§7Bukkit: §3" + ((version != null)? version.getBukkitVersion() : "null") + "\n" +
                    "§7Supported: §3" + supportedVersion + "\n" +
                    "\n");

        }

        return this;
    }

    // Is supported version?
    public boolean isSupported() {
        return version != null && version.getRaw() > 18;
    }

    // Enable logic
    public void enable() {

        // Is version supported to enable?
        if (isSupported()) {

            // Load Listener Manager
            Bukkit.getPluginManager().registerEvents(new ListenerManager(), plugin);

            // Load packet manager if is supported
            ServiceLoader.load(PacketManager.class).forEach(
                    (manager) -> {

                        // Set packet manager if is supported
                        if (manager.isSupported(version)) {
                            packetManager = manager;
                        }

                    }
            );

        }

    }

    // Close logic
    public void close() {

    }

    // Add player to cache
    public void addFantasyPlayer(UUID uuid, FantasyPlayer fantasyPlayer) {
        players.put(uuid, fantasyPlayer);
    }

    // Remove player from cache
    public void removeFantasyPlayer(UUID uuid) {
        players.remove(uuid);
    }

    // Get FantasyPlayer
    public FantasyPlayer getFantasyPlayer(UUID uuid) {
        return players.get(uuid);
    }

    // Get data folder
    public File getDataFolder() {
        return dataFolder;
    }

    // Get plugin instance
    public Plugin getPlugin() {
        return plugin;
    }

    // Get packet manager
    public PacketManager getPacketManager() {
        return packetManager;
    }

}
