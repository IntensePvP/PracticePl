package fr.Intense.Practice.managers;

import fr.Intense.Practice.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class FightingManager {

    public Map<Player, Player> fightingNoDebuff = new HashMap<>();

    public void addFightingNoDebuff(Player player, Player t){
        fightingNoDebuff.put(player, t);
        player.getInventory().clear();
        t.getInventory().clear();
        Main.getInstance().queues.noDebuffQueue.remove(player);
        Main.getInstance().queues.noDebuffQueue.remove(t);

        player.sendMessage("§bDuel trouvé !");
        player.sendMessage("§cAdversaire: " + t.getName());
        t.sendMessage("§bDuel trouvé !");
        t.sendMessage("§cAdversaire: " + player.getName());

        player.getInventory().setItem(0, new ItemStack((Material.DIAMOND_SWORD)));
        t.getInventory().setItem(0, new ItemStack((Material.DIAMOND_SWORD)));
    }
}
