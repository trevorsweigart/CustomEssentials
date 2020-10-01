package me.icefizz.customessentials;

import me.icefizz.customessentials.commands.IPCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        new IPCommand(this);
    }
}
