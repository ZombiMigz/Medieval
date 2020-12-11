package org.whitemist.medieval.modules.map;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.whitemist.medieval.Main;

public class MapCommand implements CommandExecutor {
    String ip;
    public MapCommand (Main instance) {
        ip = instance.getServer().getIp();
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (s.equals("map") && sender instanceof Player) {
            Player p = (Player) sender;
            TextComponent message = new TextComponent(ChatColor.GREEN + "[Click me to open map]" );
            message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "http://144.217.199.1:8002/" ) );
            sender.spigot().sendMessage( message );
            return true;
        }
        return false;
    }
}
