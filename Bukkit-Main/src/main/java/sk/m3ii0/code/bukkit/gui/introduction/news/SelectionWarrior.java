package sk.m3ii0.code.bukkit.gui.introduction.news;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import sk.m3ii0.code.bukkit.gui.GUI;
import sk.m3ii0.code.bukkit.gui.GUIItem;
import sk.m3ii0.code.bukkit.gui.introduction.IntroductionGUI;
import sk.m3ii0.code.bukkit.item.UItem;
import sk.m3ii0.code.bukkit.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectionWarrior extends GUI {

    // Constructor
    public SelectionWarrior() {

        // Match constructor
        super("&0Warrior", 54);

        // Items map
        final Map<Character, GUIItem> items = new HashMap<>();

        // Layout
        List<String> layout = List.of(
                "----m----",
                "         ",
                " 123 456 ",
                " fed cba ",
                "         ",
                "---x-o---"
        );

        // Add borders
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

        // Add male symbol
        items.put('m', new GUIItem() {
            @Override
            public ItemStack item() {
                return Utils.Heads.MALE.getAsUItem()
                        .setName("&fMale &7character")
                        .toItem();
            }

            @Override
            public void onClick(Player player, GUI gui, ClickType clickType, int slot) {

            }
        });

        // Add cancel symbol
        items.put('x', new GUIItem() {
            @Override
            public ItemStack item() {
                return Utils.Heads.MENU_CLOSE.getAsUItem()
                        .setName("&cBack")
                        .toItem();
            }

            @Override
            public void onClick(Player player, GUI gui, ClickType clickType, int slot) {
                gui.close(player);
                IntroductionGUI.open(player);
            }
        });

        // Set items
        int counter = 0;
        for (String line : layout) {
            for (char character : line.toCharArray()) {
                if (items.containsKey(character)) {
                    setItem(counter, items.get(character));
                }
                ++counter;
            }
        }

    }

}
