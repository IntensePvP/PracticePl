package fr.Intense.Practice.managers;

import fr.Intense.Practice.Main;
import fr.Intense.Practice.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager {

    public void registers(Main main){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinEvent(), main);
        pm.registerEvents(new PlayerQuitEvent(), main);
        pm.registerEvents(new PlayerInteractEvent(), main);
        pm.registerEvents(new InventoryClickEvent(), main);
        pm.registerEvents(new PlayerChatEvent(), main);
    }
}
