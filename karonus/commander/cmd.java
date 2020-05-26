package karonus.commander;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class cmd implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length >= 1 && cmd.getName().equalsIgnoreCase("kcmd")) {
			StringBuilder argsPar = new StringBuilder();
			for (int i = 0; i < args.length; i++) argsPar.append(args[i]).append(' ');
			if (argsPar.length() > 0) argsPar.deleteCharAt(argsPar.length() - 1);
			String command = argsPar.toString();
			
			if (sender.hasPermission("commander.cmd") == false) {
				sender.sendMessage("§cError! You don't have permissions §c(§fcommander.cmd§c)§c.");
				
				return true;
			}
			
			if (func.sendCommand(command) == true) {
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
