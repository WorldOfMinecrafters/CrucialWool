package me.nopresnik.CrucialWool;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LoginLogoutListner implements Listener {
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.RED + "[PlayerJoin] " + ChatColor.DARK_GRAY + player.getDisplayName());
    }
	
	@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.RED + "[PlayerQuit] " + ChatColor.DARK_GRAY + player.getDisplayName());
    }

}
