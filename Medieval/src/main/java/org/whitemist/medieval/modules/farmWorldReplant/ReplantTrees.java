package org.whitemist.medieval.modules.farmWorldReplant;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.scheduler.BukkitRunnable;

public class ReplantTrees extends BukkitRunnable {
    Location loc;
    Material m;
    BlockFace face;

    public ReplantTrees(Location loc, Material type) {
        this.loc = loc;
        this.m = type;
    }

    public void run() {
        System.out.println(m.toString());
        if (m == Material.OAK_LOG) {
            loc.getBlock().setType(Material.OAK_SAPLING);
        }
        if (m == Material.DARK_OAK_LOG) {
            loc.getBlock().setType(Material.DARK_OAK_SAPLING);
        }
        if (m == Material.BIRCH_LOG) {
            loc.getBlock().setType(Material.BIRCH_SAPLING);
        }
        if (m == Material.SPRUCE_LOG) {
            loc.getBlock().setType(Material.SPRUCE_SAPLING);
        }
        if (m == Material.ACACIA_LOG) {
            loc.getBlock().setType(Material.ACACIA_SAPLING);
        }
        if (m == Material.JUNGLE_LOG) {
            loc.getBlock().setType(Material.JUNGLE_SAPLING);
        }
        return;

    }
}
