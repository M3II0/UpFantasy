package sk.m3ii0.code.bukkit.utils;

import java.awt.*;

public class ColorPicker {

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

    }

}
