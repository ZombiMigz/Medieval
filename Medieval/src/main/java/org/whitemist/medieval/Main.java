package org.whitemist.medieval;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.whitemist.medieval.modules.announcements.AnnouncementHandler;
import org.whitemist.medieval.modules.farmWorldReplant.FarmWorldHandler;
import org.whitemist.medieval.modules.map.MapCommand;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        initializeModules();

    }

    public void initializeModules() {
        this.getCommand("map").setExecutor(new MapCommand(this));
        FarmWorldHandler.init(this);
        AnnouncementHandler.init(this);
    }
}
