package me.nopresnik.CrucialWool;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MobSpawnerListner implements Listener {
	
	@EventHandler
	(priority = EventPriority.LOW, ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event)
	{
	    if(event.getBlock().getType() == Material.MOB_SPAWNER)
	    {
	        Block block = event.getBlock();
	        block.setType(Material.AIR);
	        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MOB_SPAWNER, 1));
	        event.setCancelled(true);
	    }
	}
}
