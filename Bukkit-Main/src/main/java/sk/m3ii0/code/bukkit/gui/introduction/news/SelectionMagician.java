package sk.m3ii0.code.bukkit.gui.introduction.news;

import sk.m3ii0.code.bukkit.gui.GUI;

import java.util.List;

public class SelectionMagician extends GUI {

    // Constructor
    public SelectionMagician() {

        // Match constructor
        super("&0Magician", 54);

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