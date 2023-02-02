package sk.m3ii0.code.bukkit.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import sk.m3ii0.code.bukkit.item.UItem;

import java.awt.*;

public class Constants {

    // Head class
    public enum Heads {

        WARRIOR_ICON_A(6, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODMxNTJiMzhkYzE0MjU4OGQxNGZkZDM4YWFhMGI1NGU2MTM4NjBmN2QxNTM5NTM1YjMyYzAxZWIyMjBmZTY3YiJ9fX0="),
        WARRIOR_ICON_B(5, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjU3OGIzNmJlMGNkMGNjODQ4ZDYxNzQyNmNlODZlYTQ3MmE2MzAyMTE5ZTBhMzJmYWIxZWFkZDhmOGI1M2RiOCJ9fX0="),
        WARRIOR_ICON_C(4, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzc3M2U0YWJmMGEyMzM4ZTMxMjZkZTA3YjQwMWJhZjY1YTQyYTQzOGE1YzdiZTA1YjJiNDIxNmE4MzdkNTVhOSJ9fX0="),
        WARRIOR_ICON_D(3, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDNhNTIzYjA0MjI0MTg3NTYxYjQ0YzJiNzNlMTY0YjVjN2EyNDI5N2M0YTNmZjg2ZTg2ZTk4ZmM0MjU1NDU4YSJ9fX0="),
        WARRIOR_ICON_E(2, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDQyMWE4NGYwZjA5MWU1NzNhYzFhNjNkYWQ3ZTQyOTEyN2EwZTdjNDA0OGM5ZDA2MzQxYjc1Y2U4MGQ0YWU4NCJ9fX0="),
        WARRIOR_ICON_F(1, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM5NDQ4ODljNGI1OGUxZWE3NGJjMWE2YTc5YWJiOWU0NTFjZjRhZmUyODAxMTI2ZmVjZWVjYTNlYzRmNDJiMCJ9fX0="),

        MAGICIAN_ICON_A(6, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTJjYWU0MzJkODRjMzU5NGU3ZTc2YjNmNTJkMmMxNDNlZDQwM2E2NThhOGU0ODhjYjdmNTY2ZTBhMjcwNjcwIn19fQ=="),
        MAGICIAN_ICON_B(5, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTFkYWJmNzU4NWFlNDliZTM0ZDRlNGQ1ZmZmNmJkZmQ3ODRkYzYyY2ZhNzRhY2Q0MmViMmE2ZGI4OThkMGRiNiJ9fX0="),
        MAGICIAN_ICON_C(4, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjRhMDlhMmNiYzNlMjg2NTVjZDI2MDM3NjU3NGE2NGI3NzJkZTM3YWZlNDdlZDEyZWI1NDU0Nzk3ZjA0NjgyMiJ9fX0="),
        MAGICIAN_ICON_D(3, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGVhYjQwZjQzODUzYTc1YzUwOWY4NmU0NTFkYTM2OTljNGIzMDhkOTYzMDY4N2QxMDhhNzYzYjQyNTkzYzQ2ZCJ9fX0="),
        MAGICIAN_ICON_E(2, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTFlZjgwN2QxYzEzOTI1MGNiMzM0MjQxZDZkY2RjYjE4NmZlYmJjYzRiYzU2ZDBlNGQ4YjhjYWRiMjdhN2I2YSJ9fX0="),
        MAGICIAN_ICON_F(1, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWM1YjY5ODQ2YzI2MmNmNzcxYjMyMTgwNTliNjlmMTVlY2JjNWMzMmVmZDc2OThkOTc5NGM4ZDc2MGZlMzJmZSJ9fX0=");

        // Constructor
        Heads(int level, String texture) {

            // Set texture constant
            this.texture = texture;

            // Set level constant
            this.level = level;

        }

        // Texture
        private final String texture;

        // Level
        private final int level;

        // Get texture
        public String getTexture() {
            return texture;
        }

        // Get level
        public int getLevel() {
            return level;
        }

        // Is leveled
        public boolean isLeveled() {
            return level > 0;
        }

        // Get texture as UItem
        public UItem getAsUItem() {
            return new UItem(Material.PLAYER_HEAD).customSkull(texture);
        }

        // Get texture as ItemStack
        public ItemStack getAsItemStack() {
            return new UItem(Material.PLAYER_HEAD).customSkull(texture).toItem();
        }

    }

    // Color pattern class
    public static class ColorPattern {

        // Warrior
        public enum Warrior {

            // A schemes
            A1("#fce026", "#fce33d"),
            A2("#dbc118", "#fce026"),
            A3("#ccb41b", "#dbc118"),

            // B schemes
            B1("#ad8109", "#ccb41b"),
            B2("#9e5c06", "#ad8109"),
            B3("#bf7515", "#9e5c06"),

            // C schemes
            C1("#c26e00", "#bf7515"),
            C2("#db7c00", "#c26e00"),
            C3("#ff9100", "#db7c00"),

            // D schemes
            D1("#ff9812", "#ff9100"),
            D2("#ffa229", "#ff9812"),
            D3("#ffad42", "#ffa229"),

            // E schemes
            E1("#ffb452", "#ffad42"),
            E2("#ffbc63", "#ffb452"),
            E3("#ffc273", "#ffbc63"),

            // F schemes
            F1("#fccd90", "#ffc273"),
            F2("#ffd9a8", "#fccd90"),
            F3("#ffe6c4", "#ffd9a8");

            // Constructor
            Warrior(String start, String end) {

                // Set colors
                this.start = start;
                this.end = end;

            }

            // Start of the gradient
            private final String start;

            // End of the gradient
            private final String end;

            // Get Raw Start
            public String getRawStart() {
                return start;
            }

            // Get Raw End
            public String getRawEnd() {
                return end;
            }

            // Get Start
            public String getStart() {
                return "<" + start + ">";
            }

            // Get End
            public String getEnd() {
                return "</" + end + ">";
            }

            // Wrap text
            public String wrapText(String text) {
                return getStart() + text + getEnd();
            }

            // Raw start color
            public Color startColor() {
                return Color.decode(start);
            }

            // Raw end color
            public Color endColor() {
                return Color.decode(end);
            }

        }

        // Magician
        public enum Magician {

            // A schemes
            A1("#b816aa", "#a30096"),
            A2("#bf00e6", "#b816aa"),
            A3("#d814ff", "#bf00e6"),

            // B schemes
            B1("#da24ff", "#d814ff"),
            B2("#cb2feb", "#da24ff"),
            B3("#b71ed6", "#cb2feb"),

            // C schemes
            C1("#a123ba", "#b71ed6"),
            C2("#85169c", "#a123ba"),
            C3("#62169c", "#85169c"),

            // D schemes
            D1("#7c2eb8", "#62169c"),
            D2("#8015d1", "#7c2eb8"),
            D3("#7c00db", "#8015d1"),

            // E schemes
            E1("#9814fc", "#7c00db"),
            E2("#a430fc", "#9814fc"),
            E3("#af4dfa", "#a430fc"),

            // F schemes
            F1("#a660db", "#af4dfa"),
            F2("#b67ee0", "#a660db"),
            F3("#d399ff", "#b67ee0");

            // Constructor
            Magician(String start, String end) {

                // Set colors
                this.start = start;
                this.end = end;

            }

            // Start of the gradient
            private final String start;

            // End of the gradient
            private final String end;

            // Get Raw Start
            public String getRawStart() {
                return start;
            }

            // Get Raw End
            public String getRawEnd() {
                return end;
            }

            // Get Start
            public String getStart() {
                return "<" + start + ">";
            }

            // Get End
            public String getEnd() {
                return "</" + end + ">";
            }

            // Wrap text
            public String wrapText(String text) {
                return getStart() + text + getEnd();
            }

            // Raw start color
            public Color startColor() {
                return Color.decode(start);
            }

            // Raw end color
            public Color endColor() {
                return Color.decode(end);
            }

        }

    }

}