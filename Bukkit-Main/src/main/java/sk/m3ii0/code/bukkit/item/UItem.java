package sk.m3ii0.code.bukkit.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import sk.m3ii0.code.bukkit.colors.Hex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UItem {

    // Item
    private ItemStack item;

    // Meta
    private ItemMeta meta;

    // Constructor
    public UItem(Material material) {

        // Get item
        this.item = new ItemStack(material);

        // Get item meta
        this.meta = this.item.getItemMeta();

    }

    // Custom skull
    public UItem customSkull(String texture) {

        // Return if url is empty
        if (texture.isEmpty()) {
            return this;
        }

        // Create skull meta
        SkullMeta headMeta = (SkullMeta) this.item.getItemMeta();

        // Create game profile
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        // Set texture
        profile.getProperties().put("textures", new Property("textures", texture));

        // Set field
        Field profileField;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ignored) {}

        // Set item meta
        this.item.setItemMeta(headMeta);
        this.meta = headMeta;

        return this;
    }

    // Set name
    public UItem setName(String name) {
        meta.setDisplayName(Hex.colorize(name));
        return this;
    }

    // Set lore
    public UItem setLore(String... lines) {

        // Lore list
        List<String> lore = new ArrayList<>();

        // Colorize and add to lore list
        for (String line : lines) {
            lore.add(Hex.colorize(line));
        }

        // Set lore to meta
        meta.setLore(lore);

        return this;
    }

    // Convert to item
    public ItemStack toItem() {

        // Set meta to item
        item.setItemMeta(meta);

        return item;
    }

}
