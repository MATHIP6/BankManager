package fr.mathip;

import fr.mathip.Commands.BankCommand;
import fr.mathip.Listeners.OnInvClosed;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    private static Main instance;
    @Override
    public void onEnable() {
        if (!getDataFolder().exists()){
            getDataFolder().mkdir();
        }
        instance = this;
        Bukkit.getServer().getPluginManager().registerEvents(new OnInvClosed(), this);
        getCommand("bank").setExecutor(new BankCommand());
    }
    public static Main getInstance() {return instance;}

    public void createData(String fileName){
        if (!getDataFolder().exists()){
            getDataFolder().mkdir();
        }
        File data = new File(getDataFolder() + "/data/");
        if (!data.exists()){
            data.mkdir();
        }


        File file = new File(data, fileName);

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public File getFile(String fileName){
        return new File(getDataFolder() + "/data/" + fileName);
    }
}
