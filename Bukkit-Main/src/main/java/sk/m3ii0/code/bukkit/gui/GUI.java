package sk.m3ii0.code.bukkit.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import sk.m3ii0.code.bukkit.colors.Hex;
import sk.m3ii0.code.bukkit.listeners.menu.MenuListener;

import java.util.HashMap;
import java.util.Map;

public class  GUI {

    // Menu title
    private final String title;

    // Menu size
    private final int size;

    // Inventory
    private final Inventory gui;

    // Item map
    private final Map<Integer, GUIItem> items = new HashMap<>();

    // Interactivity
    private boolean interactive;

    // Constructor
    public GUI(String title, int size) {

        this.title = title;
        this.interactive = false;

        switch (size) {
            case 54 -> this.size = 54;
            case 45 -> this.size = 45;
            case 36 -> this.size = 36;
            case 27 -> this.size = 27;
            case 18 -> this.size = 18;
            default -> this.size = 9;
        }

        gui = Bukkit.createInventory(null, this.size, Hex.colorize(title));

    }

    // Get size
    public int getSize() {
        return size;
    }

    // Is menu interactive
    public boolean isInteractive() {
        return interactive;
    }

    // Set interactivity
    public void setInteractive(boolean interactive) {
        this.interactive = interactive;
    }

    // Get title
    public String getTitle() {
        return title;
    }

    // Get raw inventory
    public Inventory getGui() {
        return gui;
    }

    // Parse click
    public void parseClick(Player player, ClickType clickType, int slot) {

        // Check if slot exists
        if (items.containsKey(slot)) {

            // Get item
            GUIItem item = items.get(slot);

            // Parse click
            item.onClick(player, this, clickType, slot);

        }

    }

    // Add item
    public void addItem(GUIItem item) {
        items.put(items.size(), item);
        gui.addItem(item.item());
    }

    // Add item to slot
    public void setItem(int slot, GUIItem item) {
        items.put(slot, item);
        gui.setItem(slot, item.item());
    }

    // Open inventory
    public void open(Player player) {

        // Add player to map
        MenuListener.parseOpen(player, this);

        // Open GUI
        player.openInventory(gui);

    }

    // Close inventory
    public void close(Player player) {

        // Remove player from map
        MenuListener.parseQuit(player);

        // Close GUI
        player.closeInventory();

    }

}
