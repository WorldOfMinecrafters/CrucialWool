package me.nopresnik.CrucialWool;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

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

}
