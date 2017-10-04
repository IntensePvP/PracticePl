package fr.Intense.Practice.events;

import fr.Intense.Practice.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener{

    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event){
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        if(event.getCurrentItem() == null)return;
        if(event.getCurrentItem().getItemMeta() == null)return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null)return;
        if(player.getOpenInventory().getTitle().equalsIgnoreCase("§6Non-Classé")){
                switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§cNoDebuff":
                        Main.getInstance().queues.addNoDebuffQueue(player);
                        player.closeInventory();
                        if(Main.getInstance().queues.noDebuffQueue.size() >= 2){
                            Player t = Main.getInstance().queues.noDebuffQueue.get(0);

                            Main.getInstance().fm.addFightingNoDebuff(player, t);
                        }
                        break;
                        default: break;
                }
        }
    }
}
