package de.lewe.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;





public class SpawnManager implements CommandExecutor{

	public static File ordner = new File("plugins//TPSpawnPlugin//");
	public static File config = new File("plugins//TPSpawnPlugin", "Locations.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(config);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if(p.hasPermission("TeleportSpawn.use")){
			if(args.length == 0){
				p.sendMessage("§cBitte benutze den Befehl /Setspawn <Spawn>");

			}else if(args.length == 1){
				
				if(args[0].equalsIgnoreCase("Spawn")){
					String world = p.getWorld().getName();
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					double yaw = p.getLocation().getYaw();
					double pitch = p.getLocation().getPitch();
					cfg.set("Spawn.world", world);
					cfg.set("Spawn.x", x);
					cfg.set("Spawn.y", y);
					cfg.set("Spawn.z", z);
					cfg.set("Spawn.yaw", yaw);
					cfg.set("Spawn.pitch", pitch);
					
					try {
						cfg.save(config);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.sendMessage("§7Der Spawn wurde §aerfolgreich §7gesetzt!");
					
				}
					
				}else{
					
					p.sendMessage("§cBitte benutze den Befehl /Setspawn <Spawn>");
				}
			}else{
				p.sendMessage("§cDu hast leider keine Berrechtigung diesen befehl auszuführen!");
				
			}
			
		return false;
		}

		public static void TPtoSpawn(Player p, Sound sound){
			
		String world = cfg.getString("Spawn.world");
		double x = cfg.getDouble("Spawn.x");
		double y = cfg.getDouble("Spawn.y");
		double z = cfg.getDouble("Spawn.z");
		double yaw = cfg.getDouble("Spawn.yaw");
		double pitch = cfg.getDouble("Spawn.pitch");
		
		Location loc = new Location(Bukkit.getWorld(world), x, y, z);
		loc.setYaw((float) yaw);
		loc.setPitch((float) pitch);
		
		p.teleport(loc);
		
		p.playSound(p.getLocation(), sound, 4, 5);

	}
	
	
}
