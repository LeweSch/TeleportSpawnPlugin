package de.lewe.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TpSpawn extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new MoveListener(), this);
		getCommand("setspawn").setExecutor(new SpawnManager());
		
	}
	
	
	
	@Override
	public void onDisable() {
	}

	

}
