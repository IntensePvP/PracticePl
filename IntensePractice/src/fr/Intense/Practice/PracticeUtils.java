package fr.Intense.Practice;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PracticeUtils {

    public void givePracticeItems(Player player){
        Main.getInstance().hubplayers.add(player);
        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.playSound(player.getLocation(), Sound.LEVEL_UP,1 ,1);


        ItemStack unranked = new ItemStack(Material.IRON_SWORD);
        ItemMeta unrankedm = unranked.getItemMeta();
        unrankedm.setDisplayName("§6Non-Classé");
        unranked.setItemMeta(unrankedm);

        ItemStack ranked = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta rankedm = ranked.getItemMeta();
        rankedm.setDisplayName("§6Classé");
        ranked.setItemMeta(rankedm);

        ItemStack boutique = new ItemStack(Material.GOLD_INGOT);
        ItemMeta boutiquem = boutique.getItemMeta();
        boutiquem.setDisplayName("§eBoutique");
        boutique.setItemMeta(boutiquem);

        ItemStack edits = new ItemStack(Material.BOOK);
        ItemMeta editsm = edits.getItemMeta();
        editsm.setDisplayName("§6Edits Kits §c(Bientôt)");
        edits.setItemMeta(editsm);

        player.getInventory().clear();
        player.getInventory().setItem(0, unranked);
        player.getInventory().setItem(1, ranked);
        player.getInventory().setItem(4, boutique);
        player.getInventory().setItem(8, edits);

    }
    public void openShopMenu(Player player){
        Inventory boutique = Bukkit.createInventory(null, 3*9, "§8[§6IntensePvP§8] §eBoutique");

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
        player.openInventory(boutique);
    }
    public void openUnrankedGui(Player player){
        Inventory unranked = Bukkit.createInventory(null, 1*9, "§6Non-Classé");


        ArrayList<String> lorenodebuff = new ArrayList<>();

        ItemStack nodebuff = new ItemStack(Material.POTION,1, (short)8197);
        ItemMeta nodebuffm = nodebuff.getItemMeta();
        nodebuffm.setDisplayName("§cNoDebuff");
        lorenodebuff.add("§6En jeu: §b" + Main.getInstance().fm.fightingNoDebuff.size());
        lorenodebuff.add("§6En attente: §b" + Main.getInstance().queues.noDebuffQueue.size());
        nodebuffm.setLore(lorenodebuff);
        nodebuff.setItemMeta(nodebuffm);

        unranked.setItem(0, nodebuff);

        player.playSound(player.getLocation(), Sound.ANVIL_USE, 1, 1);
        player.openInventory(unranked);
    }
    public void openRankedGUI(Player player){
        Inventory ranked = Bukkit.createInventory(null, 1*9, "§6Classé");

        player.playSound(player.getLocation(), Sound.ANVIL_USE, 1, 1);
        player.openInventory(ranked);
    }
}
