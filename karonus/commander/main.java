package karonus.commander;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	public static main instance;
	
	public static api api;
	
	public void onEnable() {
		instance = this;
		
		api = new api();
		
		this.getServer().getPluginManager().registerEvents(new events(), this);
		
		this.getCommand("kcmd").setExecutor((CommandExecutor)new cmd());
	}
}
