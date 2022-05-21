package dev.norska.dwaddon.vault;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.norska.dw.DeluxeWithdraw;
import dev.norska.dwaddon.vault.addon.DWVaultInterface;
import dev.norska.dwaddon.vault.ndev.NorskaHandler;
import dev.norska.niridiumcolorapi.IridiumColorAPI;
import lombok.Getter;

public class VaultAddon extends JavaPlugin {
	
	private static VaultAddon instance;
	public VaultAddon() { instance = this; }
	public static VaultAddon getInstance() { return instance; }
	
	@Getter private NorskaHandler nHandler = new NorskaHandler();
	
	@Getter private VaultEconomy vault = new VaultEconomy();
	
	public String prefix;
	
	public void onEnable() {
		

		prefix = Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.17") || Bukkit.getVersion().contains("1.18") ? 
				IridiumColorAPI.process("§8[<GRADIENT:FFE818>&lDW Addon (Vault)</GRADIENT:B7FF1D>§8]§r") :
				IridiumColorAPI.process("&8[&e&lDW Addon (Vault)&8]&r");
		
		Bukkit.getConsoleSender().sendMessage(" ");
    	Bukkit.getConsoleSender().sendMessage(prefix + " §7" + getDescription().getVersion() + "§f, a §afree §faddon by §7Norska §f- §7Thanks for using!");
		Bukkit.getConsoleSender().sendMessage(" ");
		
		checkDependencies();
		
		if (Bukkit.getServer().getPluginManager().getPlugin("DeluxeWithdraw") == null) {
			Bukkit.getConsoleSender().sendMessage(prefix + " §fCould not find DeluxeWithdraw, disabling plugin.");
			Bukkit.getConsoleSender().sendMessage(prefix + " §fPurchase the resource from here: §chttps://norska.dev/r/spigot/dw/§f, §chttps://norska.dev/r/polymart/dw/");
			getServer().getPluginManager().disablePlugin(this);
			return;
		} 
		
		generateFiles();
		cache();
		
		try {
			DeluxeWithdraw.getInstance().getAddonProvider().registerNewProvider("VAULT", new DWVaultInterface());
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void checkDependencies() {
		
		if(!vault.setupEconomy(getInstance())) {
			Bukkit.getConsoleSender().sendMessage(prefix + " §fCould not find Vault, disabling addon.");
			getServer().getPluginManager().disablePlugin(getInstance());
			return;
		}
		
	}
	
	public void generateFiles() {
		try {
			getNHandler().getConfigurationHandler().generateFiles(this);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void cache() {
		getNHandler().getCacheHandler().cache(this);
	}
	
}
