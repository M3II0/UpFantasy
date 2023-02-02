package sk.m3ii0.code.bukkit.gui.introduction;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import sk.m3ii0.code.bukkit.gui.GUI;
import sk.m3ii0.code.bukkit.gui.GUIItem;
import sk.m3ii0.code.bukkit.internal.UpFantasy;
import sk.m3ii0.code.bukkit.item.UItem;
import sk.m3ii0.code.bukkit.utils.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class IntroductionGUI implements Listener {

    // Set of cancellation
    private final static Set<UUID> non_permitted = new HashSet<>();

    // Constructor
    public IntroductionGUI() {

        // Register listener
        Bukkit.getPluginManager().registerEvents(this, UpFantasy.get().getPlugin());

    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {

        // Open GUI if player doesn't have selected a group
        if (non_permitted.contains(e.getPlayer().getUniqueId())) {
            open((Player) e.getPlayer());
        }

    }

    // Open menu
    public static void open(Player player) {

        // Add player to non_permitted set
        non_permitted.add(player.getUniqueId());

        // Set layout
        List<String> layout = List.of(
                "---------",
                "         ",
                " 1 2 3 4 ",
                " 5 6 7 8 ",
                "         ",
                "---------"
        );

        // Create GUI
        GUI gui = new GUI("&0Pick your character", 54);

        gui.addItem(new GUIItem() {
            @Override
            public ItemStack item() {
                return Utils.ItemBuilder.newWarrior(player.getName());
            }

            @Override
            public void onClick(Player player, GUI gui, ClickType clickType, int slot) {
                non_permitted.remove(player.getUniqueId());
                gui.close(player);
            }
        });

        gui.open(player);

    }

}
