package org.whitemist.medieval.modules.farmWorldReplant;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.scheduler.BukkitRunnable;

public class Replant extends BukkitRunnable {
    Location loc;
    Material type;
    BlockFace face;

    public Replant(Location loc, Material type) {
        this.loc = loc;
        this.type = type;
    }

    public Replant(Location loc, Material type, BlockFace face) {
        this.loc = loc;
        this.type = type;
        this.face = face;
    }

    public void run() {


        Block block = Bukkit.getWorld("FarmWorld").getBlockAt(loc);
        block.setType(type);
        Ageable ageable = (Ageable) block.getBlockData();
        ageable.setAge(0);
        block.setBlockData((BlockData) ageable);
        return;

    }
}
