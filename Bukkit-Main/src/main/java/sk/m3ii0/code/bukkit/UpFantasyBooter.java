package sk.m3ii0.code.bukkit;

import org.bukkit.plugin.java.JavaPlugin;
import sk.m3ii0.code.bukkit.internal.UpFantasy;

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

    }

    @Override
    public void onDisable() {

        // Close plugin
        if (upFantasy != null) {
            upFantasy.close();
        }

    }

}