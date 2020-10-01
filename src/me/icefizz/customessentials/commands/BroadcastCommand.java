package me.icefizz.customessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.icefizz.customessentials.Main;
import net.md_5.bungee.api.ChatColor;

public class BroadcastCommand implements CommandExecutor {
	String command = "bc";
	@SuppressWarnings("unused")
	private Main plugin;
	
	public BroadcastCommand(Main plugin) {
		this.plugin=plugin;
		plugin.getCommand("bc").setExecutor(this);
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender.hasPermission("customessentials.broadcast"))) {
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to execute this command");
			return true;
		}else if(args.length==0) {
			sender.sendMessage(ChatColor.DARK_RED + "Please type something to have it broadcasted");
			return true;
		}else {
			Bukkit.broadcastMessage(ChatColor.DARK_GRAY+""+ChatColor.BOLD+"["+ChatColor.DARK_RED+""+ChatColor.BOLD+"ALERT"+ChatColor.DARK_GRAY+""+ChatColor.BOLD+"]"+" "+ChatColor.GOLD+""+ChatColor.BOLD+message(args));
			return true;
			}
		
	}
	
	public String message(String[] args) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<args.length;i++) {
			builder.append(args[i]);
			builder.append(" ");}
			return builder.toString().trim();
		
	}
		
}
