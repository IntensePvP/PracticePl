package fr.Intense.Practice.events;

import fr.Intense.Practice.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class PlayerInteractEvent implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(org.bukkit.event.player.PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(!event.hasItem())
            return;
        if(Main.getInstance().hubplayers.contains(player) || Main.getInstance().queues.noDebuffQueue.contains(player)){
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                switch(event.getItem().getType()){
                    case IRON_SWORD:
                        Main.getInstance().pu.openUnrankedGui(player);

                        break;

                    case DIAMOND_SWORD:
                        Main.getInstance().pu.openRankedGUI(player);

                        break;

                    case GOLD_INGOT:
                        Main.getInstance().pu.openShopMenu(player);

                        break;

                    case BOOK:
                        player.sendMessage("§cEdits kits en déveleoppement");

                        break;

                    case REDSTONE_BLOCK:
                        Main.getInstance().queues.remobeNoDebuffQueue(player);
                        break;
                        default: break;
                }
            }
        }
    }
}
