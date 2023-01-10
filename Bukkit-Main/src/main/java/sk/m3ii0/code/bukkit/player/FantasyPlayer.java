package sk.m3ii0.code.bukkit.player;

import org.bukkit.entity.Player;
import sk.m3ii0.code.bukkit.clans.Clan;

public class FantasyPlayer {

    // Player implementation
    private final Player player;

    // Player's clan
    private Clan clan;

    // Player's dynamic values
    private boolean crouch;

    // Constructor
    public FantasyPlayer(Player player) {

        // Set player instance
        this.player = player;

        // Set player's dynamic values
        this.crouch = false;

    }

    // Get player
    public Player getPlayer() {
        return player;
    }

    // Get clan
    public Clan getClan() {
        return clan;
    }

    // Is player couching?
    public boolean isCrouching() {
        return crouch;
    }

    // Set player's crouching
    public void setCrouching(boolean value) {
        this.crouch = value;
    }

}
