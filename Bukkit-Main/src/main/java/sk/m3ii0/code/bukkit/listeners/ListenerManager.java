package sk.m3ii0.code.bukkit.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import sk.m3ii0.code.bukkit.internal.UpFantasy;
import sk.m3ii0.code.bukkit.player.FantasyPlayer;
import sk.m3ii0.code.bukkit.player.io.CachedData;

import java.util.UUID;

public class ListenerManager implements Listener {

    // Constructor
    public ListenerManager() {

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

        // Set player as loaded
        fantasyPlayer.setLoaded(true);

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {

        // Get UUID
        UUID uuid = e.getPlayer().getUniqueId();

        // Get FantasyPlayer
        FantasyPlayer fantasyPlayer = UpFantasy.get().getFantasyPlayer(uuid);

        // Unset FantasyPlayer as loaded
        fantasyPlayer.setLoaded(false);

        // Remove FantasyPlayer from map
        UpFantasy.get().removeFantasyPlayer(uuid);

    }


}
