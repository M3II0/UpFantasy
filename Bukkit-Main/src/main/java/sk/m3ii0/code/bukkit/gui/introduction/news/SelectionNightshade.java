package sk.m3ii0.code.bukkit.gui.introduction.news;

import sk.m3ii0.code.bukkit.gui.GUI;

import java.util.List;

public class SelectionNightshade extends GUI {

    // Constructor
    public SelectionNightshade() {

        // Match constructor
        super("&0Nightshade", 54);

        // Layout
        List<String> layout = List.of(
                "----m----",
                "         ",
                " 123 456 ",
                " fed cba ",
                "         ",
                "---x-o---"
        );

    }

}
