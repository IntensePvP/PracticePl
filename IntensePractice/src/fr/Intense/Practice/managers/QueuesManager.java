package fr.Intense.Practice.managers;

import fr.Intense.Practice.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class QueuesManager {

    public ArrayList<Player> noDebuffQueue = new ArrayList<>();

    public void addNoDebuffQueue(Player player){
        noDebuffQueue.add(player);
        Main.getInstance().hubplayers.remove(player);
        player.playSound(player.getLocation(), Sound.NOTE_PLING,1,1);
        player.sendMessage("§bEn Attente ...");

        ItemStack leave = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta leavem = leave.getItemMeta();
        leavem.setDisplayName("§cQuitter: §bNoDebuff queue.");
        leave.setItemMeta(leavem);

        ItemStack paper = new ItemStack(Material.PAPER);
        ItemMeta paperm = paper.getItemMeta();
        paperm.setDisplayName("§bNoDebuff queue !");
        paper.setItemMeta(paperm);

        player.getInventory().clear();
        player.getInventory().setItem(8,leave);
        player.getInventory().setItem(4, paper);
    }
    public void remobeNoDebuffQueue(Player player){
        noDebuffQueue.remove(player);
        Main.getInstance().pu.givePracticeItems(player);
        player.sendMessage("§cVous avez quitté la queue.");
    }
}
