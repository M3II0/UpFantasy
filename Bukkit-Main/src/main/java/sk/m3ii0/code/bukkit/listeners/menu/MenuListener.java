package sk.m3ii0.code.bukkit.listeners.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import sk.m3ii0.code.bukkit.gui.GUI;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuListener implements Listener {

    // GUIs map
    private static final Map<UUID, GUI> guis = new HashMap<>();

    // Add player
    public static void parseOpen(Player player, GUI gui) {
        guis.put(player.getUniqueId(), gui);
    }

    // Remove player
    public static void parseQuit(Player player) {
        guis.remove(player.getUniqueId());
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        // Get menu
        GUI menu = guis.get(e.getWhoClicked().getUniqueId());

        // Check if menu is not null
        if (menu != null) {

            // Check if menu is interactive, is yes allow to player pick items from down inventory
            if (!menu.isInteractive()) {
                e.setCancelled(true);
            } else {
                if (e.getClickedInventory() != null) {
                    if (!(e.getClickedInventory().getHolder() instanceof Player)) {
                        e.setCancelled(true);
                    }
                }
            }

            // Get player
            Player player = (Player) e.getWhoClicked();

            // Get slot
            int slot = e.getRawSlot();

            // Get clock
            ClickType type = e.getClick();

            // Parse click
            menu.parseClick(player, type, slot);

        }

    }

    @EventHandler
    public void onQuit(InventoryCloseEvent e) {

        // Get GUI
        GUI menu = guis.get(e.getPlayer().getUniqueId());

        // Close menu if menu is not null
        if (menu != null) {
            menu.close((Player) e.getPlayer());
        }

    }

}
