package me.nopresnik.CrucialWool;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CrucialWool extends JavaPlugin{

		public void onEnable(){
		getLogger().info("Your plugin has been enabled!");

		PluginManager manager = this.getServer().getPluginManager();

		manager.registerEvents(new CrucialWoolListner(), this);
		manager.registerEvents(new LoginLogoutListner(), this);
		manager.registerEvents(new MobSpawnerListner(), this);

	}
 
	public void onDisable(){
		getLogger().info("Your plugin has been disabled.");
	
	}
	
}
