package karonus.commander;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import karonus.lang.en_EN;
import karonus.lang.ru_RU;

public class cmd implements CommandExecutor {
	String mesError;
	String mesError_Perm;
	String mesSuccess;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		FileConfiguration conf = main.getInstance().getConfig();
		
		String lang = conf.getString("lang");
		
		if (args.length >= 1 && cmd.getName().equalsIgnoreCase("kcmd")) {
			StringBuilder argsPar = new StringBuilder();
			for (int i = 0; i < args.length; i++) argsPar.append(args[i]).append(' ');
			if (argsPar.length() > 0) argsPar.deleteCharAt(argsPar.length() - 1);
			String command = argsPar.toString();
			
			if (lang.equals("en_EN")) {
				mesError = en_EN.getErrorMes();
				mesError_Perm = en_EN.getErrorPermMes();
				mesSuccess = en_EN.getSuccessMes();
			} else if (lang.equals("ru_RU")) {
				mesError = ru_RU.getErrorMes();
				mesError_Perm = ru_RU.getErrorPermMes();
				mesSuccess = ru_RU.getSuccessMes();
			}
			
			if (sender.hasPermission("commander.cmd") == false) {
				sender.sendMessage(mesError_Perm);
				
				return true;
			}
			
			if (func.sendCommand(command) == true) {
				sender.sendMessage(mesSuccess);
				
				return true;
			} else {
				sender.sendMessage(mesError);
				
				return true;
			}
		}
		
		return false;
	}
}
