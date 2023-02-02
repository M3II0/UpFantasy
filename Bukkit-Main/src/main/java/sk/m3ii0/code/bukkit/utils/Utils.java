package sk.m3ii0.code.bukkit.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import sk.m3ii0.code.bukkit.item.UItem;

import java.awt.*;

public class Utils {

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
        MAGICIAN_ICON_F(1, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWM1YjY5ODQ2YzI2MmNmNzcxYjMyMTgwNTliNjlmMTVlY2JjNWMzMmVmZDc2OThkOTc5NGM4ZDc2MGZlMzJmZSJ9fX0="),

        NIGHTSHADE_ICON_A(6, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjlkM2ZmODBlMzI0NzhkNmZjMjMxYmQyYWE3ZGZhZDNmYzRiYmI2NGY2OGJhNzlkM2ZmZDc5MmNmNTdkZjhkIn19fQ=="),
        NIGHTSHADE_ICON_B(5, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmZmNmMwNDQ1ZmI4ZWYwNjA4ODdhYzA0ZjczYTI3ZDhlYzc0MmU4NWJlN2Y2OWUyMjYwNGIwZGM4MzEwMTM1MyJ9fX0="),
        NIGHTSHADE_ICON_C(4, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjJkYzFlZDEyZWI4N2U0NWRkNGE5MTE2N2Y0OTY3ZTE4OTBiZjRjMjk5MzY2NzVmMmQxM2FiYWNiZjJhYTA5YSJ9fX0="),
        NIGHTSHADE_ICON_D(3, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmFiOGY4ZTcyZmRhZWUyY2FmNzIyMGM0MzgwNTZhN2ZiNzM2M2VkYWM3OTE3NTBhMjIxYmRiOTE0ZDYyNWNiNiJ9fX0="),
        NIGHTSHADE_ICON_E(2, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTRjMmUyMmI5ZTUxODJkMDk3N2JhNWUyN2FkMDhhOTNjMWI3ZTc3ZTMyODcxNTkxN2JkYzY2YjQ4ZmJiYzNjMSJ9fX0="),
        NIGHTSHADE_ICON_F(1, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzFmZTgxYWRjOTE0YmQyZGU0YmNmNTg1N2U3YTk1MzQ2MzFiNzhlMDBlNGNhMmZhN2Y2YjlkZDA3NTIwZmFiMyJ9fX0="),

        ANGEL_ICON_A(6, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjdlMzI5YmE5YTlmODdkZTlhMjI1ZDRiYTE3ZGI0MDIzNzJmMDgwN2FmZmQ2NTA1NTk4MDRmYjBhZDkxMGUyYiJ9fX0="),
        ANGEL_ICON_B(5, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmZlZGU3MmQ5ZmM1YjI1ZWEyODU2ZDMxY2I2ZDFiMzkzNjliZDQ3MzIyODNjMGNkYjQ1OTk3MzQ2MWE4NDBiYyJ9fX0="),
        ANGEL_ICON_C(4, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGQxMTBlMDE4ZTk0OGNhNTAyZjQ1MGEyZjJjNzRkYmRiMzAyMmE5OTU0MDczMWRmMjMzOTg2ZjYwYjEwNzNjZSJ9fX0="),
        ANGEL_ICON_D(3, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWE0ZWFjYTViMGVkN2IyN2RkNTlkODFjZDBjMzg3YzcyZGFiNWU1YzJlM2M2OTI2MTI2ZWNjYzNmZjdkNzgxMiJ9fX0="),
        ANGEL_ICON_E(2, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTE0M2FlZDg4ZjEwZGUwNjM0MTJkNzRjZmFlNTFlNjZjM2E4YTg3NDQ4YTIzZDFlMWM4NDA1Y2UxZWU2OGY3ZSJ9fX0="),
        ANGEL_ICON_F(1, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjgyMTUyZTNkYzUzMjQ2OTNmODM3OGE3ZjI1OTkxMjlmMzY1ZDIxZTZkZGFlN2ZlNGFhZTJlNjdkNjcxZGM5NiJ9fX0=");

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

        // Nightshade
        public enum Nightshade {

            // A schemes
            A1("#7b6b87", "#9874b3"),
            A2("#867e8c", "#7b6b87"),
            A3("#b2a8ba", "#867e8c"),

            // B schemes
            B1("#e8abed", "#b2a8ba"),
            B2("#94798b", "#e8abed"),
            B3("#b88fab", "#94798b"),

            // C schemes
            C1("#8a7b82", "#b88fab"),
            C2("#bdaab3", "#8a7b82"),
            C3("#d9a9bf", "#bdaab3"),

            // D schemes
            D1("#b3899d", "#d9a9bf"),
            D2("#99657d", "#b3899d"),
            D3("#7d4545", "#99657d"),

            // E schemes
            E1("#b35757", "#7d4545"),
            E2("#bf7171", "#b35757"),
            E3("#c48d8d", "#bf7171"),

            // F schemes
            F1("#b59898", "#c48d8d"),
            F2("#786868", "#b59898"),
            F3("#594e4e", "#786868");

            // Constructor
            Nightshade(String start, String end) {

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

        // Angel
        public enum Angel {

            // A schemes
            A1("#7b42c2", "#6609d9"),
            A2("#8f39f7", "#7b42c2"),
            A3("#ae6bff", "#8f39f7"),

            // B schemes
            B1("#6a66d1", "#ae6bff"),
            B2("#6f6afc", "#6a66d1"),
            B3("#283ea8", "#6f6afc"),

            // C schemes
            C1("#495aab", "#283ea8"),
            C2("#3e59de", "#495aab"),
            C3("#3152f7", "#3e59de"),

            // D schemes
            D1("#1a7edb", "#3152f7"),
            D2("#399dfa", "#1a7edb"),
            D3("#56a8f5", "#399dfa"),

            // E schemes
            E1("#35b6c4", "#56a8f5"),
            E2("#4f9fa8", "#35b6c4"),
            E3("#4ebfcc", "#4f9fa8"),

            // F schemes
            F1("#47edff", "#4ebfcc"),
            F2("#7af2ff", "#47edff"),
            F3("#b5f8ff", "#7af2ff");

            // Constructor
            Angel(String start, String end) {

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

    // Symbols
    public enum Symbols {

        NEPTUNE("♆", "Warrior's symbol"),
        ANKH("☥", "Magician's symbol"),
        FARSI("☫", "Nightshade's symbol"),
        ADI_SHAKTI("☬", "Angel's symbol");

        // Constructor
        Symbols(String symbol, String note) {

            // Set symbol
            this.symbol = symbol;

        }

        // Symbol
        private final String symbol;

        // Get symbol
        public String getSymbol() {
            return symbol;
        }

    }

    // Item builder
    public static class ItemBuilder {

        public static ItemStack newWarrior(String player) {
            return Heads.WARRIOR_ICON_A.getAsUItem()
                    .setName(ColorPattern.Warrior.A1.wrapText("Warrior") + " &f" + player)
                    .setLore(
                            "",
                            " &7≢ Group symbol: " + ColorPattern.Warrior.A2.wrapText(Symbols.NEPTUNE.getSymbol() + " "),
                            " &7≢ Advantages in: &aCombat&7, &adexterity&7, &amind &7& &astrength",
                            " &7≢ Defects: &cStamina&7, &clogic&7, &calchemy &7& &cadaptability",
                            "",
                            " &7≢ Adapted for: &fMale",
                            ""
                    ).toItem();
        }

        public static ItemStack newMagician(String player) {
            return Heads.MAGICIAN_ICON_A.getAsUItem()
                    .setName(ColorPattern.Magician.A1.wrapText("Magician") + " &f" + player)
                    .setLore(
                            "",
                            " &7≢ Group symbol: " + ColorPattern.Magician.A2.wrapText(Symbols.ANKH.getSymbol() + " "),
                            " &7≢ Advantages in: &aAlchemy&7, &ateleportation&7, &amovement &7& &abackdoors",
                            " &7≢ Defects: &cCombat&7, &cstrength &7& &cwater",
                            "",
                            " &7≢ Adapted for: &fMale",
                            ""
                    ).toItem();
        }

        public static ItemStack newNightshade(String player) {
            return Heads.NIGHTSHADE_ICON_A.getAsUItem()
                    .setName(ColorPattern.Nightshade.A1.wrapText("Nightshade") + " &f" + player)
                    .setLore(
                            "",
                            " &7≢ Group symbol: " + ColorPattern.Nightshade.A2.wrapText(Symbols.FARSI.getSymbol() + " "),
                            " &7≢ Advantages in: &aCombat&7, &aalchemy&7, &astamina &7& &astrength",
                            " &7≢ Defects: &cMind&7, &clogic&7, &cnether &7& &cadaptability",
                            "",
                            " &7≢ Adapted for: &fFemale",
                            ""
                    ).toItem();
        }

        public static ItemStack newAngel(String player) {
            return Heads.ANGEL_ICON_A.getAsUItem()
                    .setName(ColorPattern.Angel.A1.wrapText("Angel") + " &f" + player)
                    .setLore(
                            "",
                            " &7≢ Group symbol: " + ColorPattern.Angel.A2.wrapText(Symbols.ADI_SHAKTI.getSymbol() + " "),
                            " &7≢ Advantages in: &aKindness&7, &alogic&7, &aalchemy &7& &astamina",
                            " &7≢ Defects: &cNether&7, &ccombat&7, &cstrength &7& &cadaptability",
                            "",
                            " &7≢ Adapted for: &fFemale",
                            ""
                    ).toItem();
        }

    }

}