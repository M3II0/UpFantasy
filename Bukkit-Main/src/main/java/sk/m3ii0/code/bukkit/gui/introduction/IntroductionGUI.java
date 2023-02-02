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

import java.util.*;

public class IntroductionGUI implements Listener {

    // Constructor
    public IntroductionGUI() {

        // Register listener
        Bukkit.getPluginManager().registerEvents(this, UpFantasy.get().getPlugin());

    }

    // Open menu
    public static void open(Player player) {

        // Set layout
        List<String> layout = List.of(
                "---------",
                "         ",
                " 1 2 3 4 ",
                " w m n a ",
                "         ",
                "---------"
        );

        // Items map
        final Map<Character, GUIItem> items = new HashMap<>();

        // Create GUI
        GUI gui = new GUI("&0Pick your character", 54);

        // Adding border
        items.put('-', new GUIItem() {
            @Override
            public ItemStack item() {
                return new UItem(Material.BLACK_STAINED_GLASS_PANE)
                        .setName("&7")
                        .toItem();
            }

            @Override
            public void onClick(Player player, GUI gui, ClickType clickType, int slot) {

            }
        });

        // Adding warrior
        items.put('1', new GUIItem() {
            @Override
            public ItemStack item() {
                return Utils.ItemBuilder.newWarrior(player.getName());
            }

            @Override
            public void onClick(Player player, GUI gui, ClickType clickType, int slot) {

            }
        });

        // Adding magician
        items.put('2', new GUIItem() {
            @Override
            public ItemStack item() {
                return Utils.ItemBuilder.newMagician(player.getName());
            }

            @Override
            public void onClick(Player player, GUI gui, ClickType clickType, int slot) {

            }
        });

        // Adding nightshade
        items.put('3', new GUIItem() {
            @Override
            public ItemStack item() {
                return Utils.ItemBuilder.newNightshade(player.getName());
            }

            @Override
            public void onClick(Player player, GUI gui, ClickType clickType, int slot) {

            }
        });

        // Adding angel
        items.put('4', new GUIItem() {
            @Override
            public ItemStack item() {
                return Utils.ItemBuilder.newAngel(player.getName());
            }

            @Override
            public void onClick(Player player, GUI gui, ClickType clickType, int slot) {

            }
        });

        // Add items to GUI
        int counter = 0;
        for (String line : layout) {
            for (char character : line.toCharArray()) {
                if (items.containsKey(character)) {
                    gui.setItem(counter, items.get(character));
                }
                ++counter;
            }
        }

        // Open GUI for player
        gui.open(player);

    }

}