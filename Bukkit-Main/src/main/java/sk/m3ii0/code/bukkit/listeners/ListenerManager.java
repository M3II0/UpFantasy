package sk.m3ii0.code.bukkit.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import sk.m3ii0.code.bukkit.gui.introduction.IntroductionGUI;
import sk.m3ii0.code.bukkit.internal.UpFantasy;
import sk.m3ii0.code.bukkit.listeners.menu.MenuListener;
import sk.m3ii0.code.bukkit.player.FantasyPlayer;
import sk.m3ii0.code.bukkit.player.io.CachedData;

import java.util.UUID;

public class ListenerManager implements Listener {

    // Constructor
    public ListenerManager() {

        // Register menu listener
        Bukkit.getPluginManager().registerEvents(new MenuListener(), UpFantasy.get().getPlugin());

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        // Cancel join message
        e.setJoinMessage("");

        // Get player
        Player player = e.getPlayer();

        // Get UUID
        UUID uuid = player.getUniqueId();

        // Create FantasyPlayer instance
        FantasyPlayer fantasyPlayer = new FantasyPlayer(player, CachedData.read(uuid));

        // Put FantasyPlayer into hashMap
        UpFantasy.get().addFantasyPlayer(uuid, fantasyPlayer);

        // Add player's join
        fantasyPlayer.addLogin();

        // Set player as loaded
        fantasyPlayer.setLoaded(true);

        // Check if player's login is first
        boolean firstLogin = fantasyPlayer.getLogins() == 1;

        // Open menu for player with instructions (If is this player's first login)
        if (firstLogin) {
            IntroductionGUI.open(player);
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {

        // Get UUID
        UUID uuid = e.getPlayer().getUniqueId();

        // Get FantasyPlayer
        FantasyPlayer fantasyPlayer = UpFantasy.get().getFantasyPlayer(uuid);

        // Unset FantasyPlayer as loaded
        fantasyPlayer.setLoaded(false);

        // Write cached values
        CachedData.write(fantasyPlayer);

        // Remove FantasyPlayer from map
        UpFantasy.get().removeFantasyPlayer(uuid);

    }


}
