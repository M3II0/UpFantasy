package sk.m3ii0.code.bukkit.internal;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import sk.m3ii0.code.bukkit.api.Version;
import sk.m3ii0.code.bukkit.listeners.ListenerManager;

import java.io.File;

public class UpFantasy implements Listener {

    // Plugin instance
    private final Plugin plugin;

    // Configuration files
    private FileConfiguration config;

    // Server info
    private Version version;

    // Constructor
    public UpFantasy(Plugin plugin) {

        this.plugin = plugin;

    }

    // Load logic
    public UpFantasy load() {

        // Create configuration files
        plugin.saveResource("config.yml", false);

        // Load configuration files
        File config = new File(plugin.getDataFolder(), "config.yml");

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

        }

    }

    // Close logic
    public void close() {

    }

}
