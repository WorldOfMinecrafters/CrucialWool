package me.nopresnik.CrucialWool;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class CrucialWoolListner implements Listener {
	
	@EventHandler
    public void onPlayerMoveWOOL(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if(block.getType() == Material.WOOL && block.getData() == 10)
            player.damage(1);
    }
	
	@EventHandler
    public void onPlayerMoveSOULSAND(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if(block.getType() == Material.SOUL_SAND)
            player.damage(20);
    }
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
	    if(event.getBlock().getType() == Material.SOUL_SAND)
	    {
	        Block block = event.getBlock();
	        block.setType(Material.AIR);
	        //event.setCancelled(true);
	    }
	}
	
	@EventHandler
	public void onBlockBreakEvent1(BlockBreakEvent event)
	{
		if(event.getBlock().getType() == Material.SMOOTH_BRICK)
		{
			event.setCancelled(true);
			Block block = event.getBlock();
			block.setData((byte) 2);
		}
	}
	
	@EventHandler
	public void onBlockBreakEvent2(BlockBreakEvent event)
	{
		Block block = event.getBlock();
		if(event.getBlock().getType() == Material.SMOOTH_BRICK && block.getData() == 2)
		{
			block.setType(Material.AIR);
			block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SMOOTH_BRICK, 1));
		}
	}
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.BLUE + "[PlayerJoin] " + ChatColor.DARK_GRAY + player.getDisplayName());
    }
	
	@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.BLUE + "[PlayerQuit] " + ChatColor.DARK_GRAY + player.getDisplayName());
    }
	
	@EventHandler
	(priority = EventPriority.LOW, ignoreCancelled = true)
	public void onBlockBreak3(BlockBreakEvent event)
	{
	    if(event.getBlock().getType() == Material.MOB_SPAWNER)
	    {
	        Block block = event.getBlock();
	        block.setType(Material.AIR);
	        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.MOB_SPAWNER, 1));
	        event.setCancelled(true);
	    }
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	 
	public void onPlayerDeathEvent(PlayerDeathEvent event)
	{
		Player player = (Player)event.getEntity();
		Location loc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY() + 5.0D, player.getLocation().getZ(), 360.0F, 0.0F);
		event.getEntity().getWorld().strikeLightningEffect(loc);
		event.getEntity().getWorld().spawnCreature(loc, EntityType.ZOMBIE);
		
	    }
	    
}

