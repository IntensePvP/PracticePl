package fr.Intense.Practice.events;

import fr.Intense.Practice.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();
        String playerName = player.getName();
        Main.getInstance().rank.registerPlayer(player);
        Main.getInstance().elos.registerElos(player);
        event.setJoinMessage("§8[§a+§8] " + Main.getInstance().rank.getRank(player).getPrefix() + playerName);
        Main.getInstance().pu.givePracticeItems(player);
    }
}
