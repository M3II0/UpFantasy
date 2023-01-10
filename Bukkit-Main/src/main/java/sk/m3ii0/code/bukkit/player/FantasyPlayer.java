package sk.m3ii0.code.bukkit.player;

import org.bukkit.entity.Player;
import sk.m3ii0.code.bukkit.player.io.CachedData;

public class FantasyPlayer {

    // Player implementation
    private final Player player;

    // Player's dynamic values
    private boolean loaded;
    private boolean crouch;

    // Constructor
    public FantasyPlayer(Player player, CachedData data) {

        // Set player instance
        this.player = player;

        // Set player's dynamic values
        this.crouch = false;
        this.loaded = false;

    }

    // Get player
    public Player getPlayer() {
        return player;
    }

    // Is player couching?
    public boolean isCrouching() {
        return crouch;
    }

    // Set player's crouching
    public void setCrouching(boolean value) {
        this.crouch = value;
    }

    // Get if player is loaded
    public boolean isLoaded() {
        return loaded;
    }

    // Set player's loaded value
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

}
