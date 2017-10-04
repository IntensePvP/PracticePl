package fr.Intense.Practice;

import fr.Intense.Practice.managers.EventsManager;
import fr.Intense.Practice.managers.FightingManager;
import fr.Intense.Practice.managers.QueuesManager;
import fr.intense.api.elos.Elos;
import fr.intense.api.rank.Rank;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin{

    public List<Player> hubplayers = new ArrayList<>();

    public PracticeUtils pu = new PracticeUtils();
    public QueuesManager queues = new QueuesManager();
    public FightingManager fm = new FightingManager();
    public Rank rank = new Rank();
    public Elos elos = new Elos();

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        new EventsManager().registers(this);
    }

    @Override
    public void onDisable() {

    }
    public static Main getInstance(){
        return instance;
    }
}
