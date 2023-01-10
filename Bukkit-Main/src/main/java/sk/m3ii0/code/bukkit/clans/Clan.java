package sk.m3ii0.code.bukkit.clans;

import org.bukkit.event.inventory.ClickType;
import sk.m3ii0.code.bukkit.player.FantasyPlayer;

public interface Clan {

    // Name
    String getName();

    // Description
    String getDescription();

    // Skill tree
    void openSkillTree();

    // Actions
    void action(FantasyPlayer player, ClickType clickType);

}
