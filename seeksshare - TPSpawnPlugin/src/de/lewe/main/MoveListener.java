package de.lewe.main;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
	
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.getLocation().getY() <= 10){
        	SpawnManager.TPtoSpawn(p, Sound.ENTITY_ENDER_DRAGON_FLAP);
        	
            }
        }

}
