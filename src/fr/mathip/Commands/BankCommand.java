package fr.mathip.Commands;

import fr.mathip.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BankCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (s.equals("bank")){
            Player p = (Player)commandSender;
            File data = new File(Main.getInstance().getDataFolder() + "/data/");
            List<File> files = Arrays.asList(data.listFiles());
            YamlConfiguration file = null;
            for (File fil : files){
                if (fil.getName().startsWith(p.getName())){
                    file = YamlConfiguration.loadConfiguration(fil);
                    break;
                }
            }
            if (file != null){
                Inventory inv = Bukkit.createInventory(null, 54, p.getName());
                inv.setContents((ItemStack[]) file.get("1"));
                p.openInventory(inv);
                return true;
            } else {
                Inventory inv = Bukkit.createInventory(null, 54, p.getName());
                p.openInventory(inv);
                return true;
            }
        }
        return false;
    }
}
