package org.whitemist.medieval.modules.farmWorldReplant;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.whitemist.medieval.Main;

import java.util.ArrayList;
import java.util.List;

public class PlantBreakListener implements Listener {
    Main plugin;
    public PlantBreakListener(Main instance) {
        this.plugin = instance;
    }

    @EventHandler()
    public void ReplantListener(BlockBreakEvent e) {
        if (e.getBlock().getWorld().getName().equalsIgnoreCase("FarmWorld")) {
            List<Material> plantlist = new ArrayList<Material>();
            plantlist.add(Material.CARROTS);
            plantlist.add(Material.WHEAT);
            plantlist.add(Material.POTATOES);
            plantlist.add(Material.BEETROOTS);
            plantlist.add(Material.COCOA);
            plantlist.add(Material.NETHER_WART);

            List<Material> grower = new ArrayList<Material>();
            grower.add(Material.CACTUS);
            grower.add(Material.SUGAR_CANE);


            List<Material> chorus = new ArrayList<Material>();
            chorus.add(Material.CHORUS_FLOWER);
            chorus.add(Material.CHORUS_PLANT);

            List<Material> dropper = new ArrayList<Material>();
            dropper.add(Material.VINE);

            List<Material> ignore = new ArrayList<Material>();
            ignore.add(Material.PUMPKIN);
            ignore.add(Material.MELON);

            List<Material> kelp = new ArrayList<Material>();
            kelp.add(Material.KELP);
            kelp.add(Material.KELP_PLANT);

            List<Material> log = new ArrayList<Material>();
            log.add(Material.ACACIA_LOG);
            log.add(Material.BIRCH_LOG);
            log.add(Material.DARK_OAK_LOG);
            log.add(Material.JUNGLE_LOG);
            log.add(Material.OAK_LOG);
            log.add(Material.SPRUCE_LOG);
            if (e.getBlock().getWorld().getName().equalsIgnoreCase("FarmWorld")) {
                if (!(e.getPlayer().hasPermission("*"))){
                    if (plantlist.contains(e.getBlock().getType())) {
                        if (e.getBlock().getType() == Material.NETHER_WART) {
                            Block b = e.getBlock();
                            Ageable ageable = (Ageable) b.getBlockData();
                            if (ageable.getAge() < 3) {
                                e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "This plant is not fully grown");
                                e.setCancelled(true);
                            } else {
                                new Replant(e.getBlock().getLocation(), e.getBlock().getType()).runTaskLater(plugin, 40L);
                            }
                        } else {
                            new Replant(e.getBlock().getLocation(), e.getBlock().getType()).runTaskLater(plugin, 40L);
                        }
                    } else {
                        if (grower.contains(e.getBlock().getType())){
                            Block b = e.getBlock();
                            Location loc = b.getLocation();
                            if (Bukkit.getWorld("FarmWorld").getBlockAt(new Location(Bukkit.getWorld("FarmWorld"), loc.getX(), loc.getY()-1, loc.getZ())).getType() != e.getBlock().getType()) {
                                e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cannot break the base of plants in this world");
                                e.setCancelled(true);
                            }
                        }else if (chorus.contains(e.getBlock().getType())) {
                            Block b = e.getBlock();
                            Location loc = b.getLocation();
                            if (Bukkit.getWorld("FarmWorld").getBlockAt(new Location(Bukkit.getWorld("FarmWorld"), loc.getX(), loc.getY()-1, loc.getZ())).getType() == Material.END_STONE) {
                                e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cannot break the base of plants in this world");
                                e.setCancelled(true);
                            }
                        }else if (dropper.contains(e.getBlock().getType())) {
                            Block b = e.getBlock();
                            Location loc = b.getLocation();
                            if (Bukkit.getWorld("FarmWorld").getBlockAt(new Location(Bukkit.getWorld("FarmWorld"), loc.getX(), loc.getY()+1, loc.getZ())).getType() != e.getBlock().getType()) {
                                e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cannot break the base of plants in this world");
                                e.setCancelled(true);
                            }
                        } else if (ignore.contains(e.getBlock().getType())){
                            e.setCancelled(false);
                        } else if (kelp.contains(e.getBlock().getType())) {
                            Block b = e.getBlock();
                            Location loc = b.getLocation();
                            if (!(kelp.contains(Bukkit.getWorld("FarmWorld").getBlockAt(new Location(Bukkit.getWorld("FarmWorld"), loc.getX(), loc.getY()-1, loc.getZ())).getType()))) {
                                e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cannot break the base of plants in this world");
                                e.setCancelled(true);
                            }
						/*} else if (log.contains(e.getBlock().getType())){
							Block b = e.getBlock();
							Location bUnder = new Location(Bukkit.getWorld("FarmWorld"), b.getX(), b.getY()-1, b.getZ());
							if (bUnder.getBlock().getType() == Material.DIRT || bUnder.getBlock().getType() == Material.COARSE_DIRT || bUnder.getBlock().getType() == Material.GRASS_BLOCK) {
								Location loc = b.getLocation();
								Material m = b.getType();
								new ReplantTrees(loc, m).runTaskLater(plugin, 1L);
							}
						} else if (e.getBlock().getType().toString().contains("LEAVES")){
							*/
                        } else {
                            e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You can only break crops in this world");
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}
