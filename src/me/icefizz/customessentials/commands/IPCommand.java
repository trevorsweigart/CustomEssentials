package me.icefizz.customessentials.commands;

import me.icefizz.customessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class IPCommand implements CommandExecutor {
    @SuppressWarnings("unused")
    private static Main plugin;

    public IPCommand(Main plugin){

        plugin.getCommand("ip").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        Player target = Bukkit.getServer().getPlayer(args[0]);

        if(!(sender.hasPermission("customessentials.viewip"))) {
            sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to execute this command!");
            return true;
        }

           else if(args[0] == null){
                sender.sendMessage(ChatColor.DARK_RED + "Please specify a player!");
                return true;
            }

           else if (target==null){
                sender.sendMessage(ChatColor.RED + "Could not find: " + ChatColor.DARK_PURPLE + args[0]);
                return true;
            }
           else{
            sender.sendMessage(ChatColor.DARK_PURPLE + args[0] + "'s IP is: " + ChatColor.GOLD + target.getAddress());
            return true;
           }

        }
}

