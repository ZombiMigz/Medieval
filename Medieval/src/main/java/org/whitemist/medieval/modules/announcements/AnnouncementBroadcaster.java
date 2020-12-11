package org.whitemist.medieval.modules.announcements;

import de.leonhard.storage.Yaml;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementBroadcaster extends BukkitRunnable {
    public void run() {
        List<String> announcements = new ArrayList<String>();


        Yaml config = new Yaml("config", "plugins/Medieval/modules/announcements");
        config.setDefault("announcements", getDefault());
        announcements = config.getStringList("announcements");

        if (announcements.size() < 0) {
            System.out.println("Announcements list is empty");
            return;
        }

        String msg =  ChatColor.BOLD + "" + ChatColor.AQUA + "[Announcements] " + announcements.get((int) (Math.random()*(announcements.size())));
        for (Player p: Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage(msg);
        }

    }

    public ArrayList<String> getDefault() {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Announcement 1");
        arr.add("Announcement 2");
        return arr;
    }
}
