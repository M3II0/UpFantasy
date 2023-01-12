package sk.m3ii0.code.bukkit.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.checkerframework.checker.guieffect.qual.UI;
import sk.m3ii0.code.bukkit.colors.Hex;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class UItem {

    // Item
    private ItemStack item;

    // Meta
    private final ItemMeta meta;

    // Constructor
    public UItem(Material material) {

        // Get item
        this.item = new ItemStack(material);

        // Get item meta
        this.meta = this.item.getItemMeta();

    }

    // Custom skull
    private UItem customSkull(String texture) {

        // Set item to skull
        item = new ItemStack(Material.PLAYER_HEAD);

        // Get skull meta
        SkullMeta headMeta = (SkullMeta) item.getItemMeta();

        // Get Game Profile
        PlayerProfile profile = new PlayerProfile() {
            @Override
            public Map<String, Object> serialize() {
                return null;
            }

            @Override
            public UUID getUniqueId() {
                return UUID.randomUUID();
            }

            @Override
            public String getName() {
                return "CustomHead";
            }

            @Override
            public PlayerTextures getTextures() {
                return new PlayerTextures() {
                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @Override
                    public void clear() {

                    }

                    @Override
                    public URL getSkin() {
                        try {
                            return new URL(texture);
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void setSkin(URL url) {

                    }

                    @Override
                    public void setSkin(URL url, SkinModel skinModel) {

                    }

                    @Override
                    public SkinModel getSkinModel() {
                        return null;
                    }

                    @Override
                    public URL getCape() {
                        return null;
                    }

                    @Override
                    public void setCape(URL url) {

                    }

                    @Override
                    public long getTimestamp() {
                        return 0;
                    }

                    @Override
                    public boolean isSigned() {
                        return false;
                    }
                };
            }

            @Override
            public void setTextures(PlayerTextures playerTextures) {

            }

            @Override
            public boolean isComplete() {
                return false;
            }

            @Override
            public CompletableFuture<PlayerProfile> update() {
                return null;
            }

            @Override
            public PlayerProfile clone() {
                return null;
            }
        };

        // Set texture
        headMeta.setOwnerProfile(profile);

        // Set item meta
        item.setItemMeta(headMeta);

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
