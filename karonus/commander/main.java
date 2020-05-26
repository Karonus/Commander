package karonus.commander;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public static boolean sendCommand(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			
			return false;
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length >= 1 && cmd.getName().equalsIgnoreCase("kcmd")) {
			StringBuilder argsPar = new StringBuilder();
			for (int i = 0; i < args.length; i++) argsPar.append(args[i]).append(' ');
			if (argsPar.length() > 0) argsPar.deleteCharAt(argsPar.length() - 1);
			String command = argsPar.toString();
			
			if (sender.hasPermission("commander.cmd")) {
				sender.sendMessage("§cError! You don't have permissions.");
				
				return true;
			}
			
			if (sendCommand(command) == true) {
				sender.sendMessage("§aSuccess!");
				
				return true;
			} else {
				sender.sendMessage("§cError!");
				
				return true;
			}
		}
		
		return false;
	}
}
