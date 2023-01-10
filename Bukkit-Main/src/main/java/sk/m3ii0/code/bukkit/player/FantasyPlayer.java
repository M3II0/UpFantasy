package sk.m3ii0.code.bukkit.player;

import org.bukkit.entity.Player;

public class FantasyPlayer {

    // Player implementation
    private final Player player;

    // Constructor
    public FantasyPlayer(Player player) {
        this.player = player;
    }

    // Get player
    public Player getPlayer() {
        return player;
    }

}
