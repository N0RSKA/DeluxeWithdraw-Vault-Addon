package dev.norska.dwaddon.vault;

import org.bukkit.plugin.RegisteredServiceProvider;

import lombok.Getter;
import net.milkbowl.vault.economy.Economy;

public class VaultEconomy {
	
	@Getter private Economy econ;

	public boolean setupEconomy(VaultAddon main) {
		if (main.getServer().getPluginManager().getPlugin("Vault") == null) return false;
		RegisteredServiceProvider<Economy> rsp = main.getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) return false;
		econ = rsp.getProvider();
		return econ != null;
	}

}
