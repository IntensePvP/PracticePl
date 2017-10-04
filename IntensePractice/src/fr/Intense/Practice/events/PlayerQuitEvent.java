package fr.Intense.Practice.events;

import fr.Intense.Practice.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {

    @EventHandler
    public void onQuit(org.bukkit.event.player.PlayerQuitEvent event){
        Player player = event.getPlayer();
        String playerName = player.getName();
        event.setQuitMessage("§8[§c-§8] " + Main.getInstance().rank.getRank(player).getPrefix() + playerName);
    }
}
