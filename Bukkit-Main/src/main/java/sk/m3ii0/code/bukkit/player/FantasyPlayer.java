package sk.m3ii0.code.bukkit.player;

import org.bukkit.entity.Player;
import sk.m3ii0.code.bukkit.player.io.CachedData;

import java.time.LocalDateTime;

public class FantasyPlayer {

    // Player implementation
    private final Player player;

    // Player's dynamic values
    private boolean loaded;
    private boolean crouch;

    // Player total logins
    private int logins;

    // Player last login
    private String lastLogin;

    // Constructor
    public FantasyPlayer(Player player, CachedData data) {

        // Set player instance
        this.player = player;

        // Set player's dynamic values
        this.crouch = false;
        this.loaded = false;

        // Set player's logins
        this.logins = data.getTotalLogin();

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

    // Add player's logins
    public void addLogin() {

        // Get time
        LocalDateTime time = LocalDateTime.now();

        // Get time values
        int year = time.getYear();
        int month = time.getMonth().getValue();
        int day = time.getDayOfMonth();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        // Set string
        lastLogin = "Date(" + year + "-" + month + "-" + day + ") Time(" + hour + "-" + minute + "-" + second + ")";

        // Add login
        ++logins;

    }

    // Get player's last login
    public String getLastLogin() {
        return lastLogin;
    }

    // Get player's logins
    public int getLogins() {
        return logins;
    }

}
