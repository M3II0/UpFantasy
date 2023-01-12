package sk.m3ii0.code.bukkit.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public interface GUIItem {

    ItemStack item();
    void onClick(Player player, GUI gui, ClickType clickType, int slot);

}
