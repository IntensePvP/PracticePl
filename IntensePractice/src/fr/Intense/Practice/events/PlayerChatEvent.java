package fr.Intense.Practice.events;

import fr.Intense.Practice.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        event.setFormat("§8[§7" + Main.getInstance().elos.getElos(event.getPlayer()) + "§8] " + Main.getInstance().rank.getRank(event.getPlayer()).getPrefix() + event.getPlayer().getName() + "§8: " + Main.getInstance().rank.getRank(event.getPlayer()).getChatColor() + event.getMessage());
    }
}
