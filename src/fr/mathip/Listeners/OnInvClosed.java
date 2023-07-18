package fr.mathip.Listeners;

import fr.mathip.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class OnInvClosed implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInvClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        if (e.getInventory().getName() == p.getName()){
            String name = p.getName();
            p.sendMessage("ccc");
            ItemStack[] inv = e.getInventory().getContents();
            Main.getInstance().createData(name + ".yml");
            YamlConfiguration file = YamlConfiguration.loadConfiguration(Main.getInstance().getFile(name + ".yml"));
            file.set("1", inv);
            try {
                file.save(Main.getInstance().getFile(name + ".yml"));
            } catch (IOException ex) {
                System.out.println("marche pas :(");
            }
        }
    }
}
