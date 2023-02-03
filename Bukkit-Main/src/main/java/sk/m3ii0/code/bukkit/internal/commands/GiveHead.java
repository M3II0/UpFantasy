package sk.m3ii0.code.bukkit.internal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import sk.m3ii0.code.bukkit.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GiveHead implements CommandExecutor, TabExecutor {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length == 1) {

            List<String> originals = new ArrayList<>();

            for (Utils.Heads var : Utils.Heads.values()) {
                originals.add(var.name());
            }

            return Utils.copyPartialMatches(strings[0], originals);
        }

        return Collections.singletonList("");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        // Try to execute command or send help message
        try {

            // Get head
            Utils.Heads head = Utils.Heads.valueOf(strings[0]);

            // Give head
            ((Player) commandSender).getInventory().addItem(head.getAsItemStack());
            ((Player) commandSender).updateInventory();

            // Message
            Utils.sendSystemMessage("Done! Head <b>" + strings[0] + "</b> has been given!", commandSender);

        } catch (Exception e) {

            // Send help message
            Utils.sendSystemMessage("Incorrect usage! <b>/givehead [EnumName]</b>. Please try again! (Make sure that command has been executed as player)", commandSender);

        }

        return false;
    }

}
