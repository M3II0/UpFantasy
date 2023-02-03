package sk.m3ii0.code.bukkit;

import org.bukkit.plugin.java.JavaPlugin;
import sk.m3ii0.code.bukkit.internal.UpFantasy;
import sk.m3ii0.code.bukkit.internal.commands.GiveHead;

public class UpFantasyBooter extends JavaPlugin {

    private UpFantasy upFantasy;

    @Override
    public void onLoad() {

        // Load plugin
        UpFantasy loader = new UpFantasy(this);
        upFantasy = loader.load();

    }

    @Override
    public void onEnable() {

        // Enable plugin
        upFantasy.enable();

        // Load commands if is supported
        if (upFantasy.isSupported()) {

            // Register give head commands
            getCommand("givehead").setExecutor(new GiveHead());
            getCommand("givehead").setTabCompleter(new GiveHead());

        }

    }

    @Override
    public void onDisable() {

        // Close plugin
        if (upFantasy != null) {
            upFantasy.close();
        }

    }

}