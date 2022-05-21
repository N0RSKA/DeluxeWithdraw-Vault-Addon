package dev.norska.dwaddon.vault.addon;

import java.util.List;

import org.bukkit.entity.Player;

import dev.norska.dw.api.DWAddonInterface;
import dev.norska.dwaddon.vault.VaultAddon;

public class DWVaultInterface implements DWAddonInterface {

	@Override
	public void take(Player p, Double amount) {
		VaultAddon.getInstance().getVault().getEcon().withdrawPlayer(p, amount);
	}

	@Override
	public void add(Player p, Double amount) {
		VaultAddon.getInstance().getVault().getEcon().depositPlayer(p, amount);
	}

	@Override
	public void set(Player p, Double amount) {}

	@Override
	public Boolean has(Player p, Double amount) {
		return VaultAddon.getInstance().getVault().getEcon().getBalance(p) >= amount;
	}

	@Override
	public void take(Player p, Integer amount) {}

	@Override
	public void add(Player p, Integer amount) {}

	@Override
	public void set(Player p, Integer amount) {}

	@Override
	public Boolean has(Player p, Integer amount) { return null; }

	@Override
	public String currencyString() {
		return VaultAddon.getInstance().getNHandler().getCacheHandler().getCurrencyName();
	}

	@Override
	public int currencyFormat() {
		return VaultAddon.getInstance().getNHandler().getCacheHandler().getCurrencyFormat();
	}

	@Override
	public Double getCurrent(Player p) {
		return VaultAddon.getInstance().getVault().getEcon().getBalance(p);
	}

	@Override
	public List<String> withdrawCommands() {
		return VaultAddon.getInstance().getNHandler().getCacheHandler().getCommands();
	}

	@Override
	public Double minWithdraw() {
		return VaultAddon.getInstance().getNHandler().getCacheHandler().getMinWithdraw();
	}

	@Override
	public Double maxWithdraw() {
		return VaultAddon.getInstance().getNHandler().getCacheHandler().getMaxWithdraw();
	}

	@Override
	public String layout() {
		return VaultAddon.getInstance().getNHandler().getCacheHandler().getItemLayout();
	}

	@Override
	public String adminCreator() {
		return VaultAddon.getInstance().getNHandler().getCacheHandler().getCreatorForAdminItems();
	}

	@Override
	public void reloadConfiguration() {
	
		VaultAddon.getInstance().generateFiles();
		VaultAddon.getInstance().cache();
		
	}

	@Override
	public Boolean useInt() {
		return false;
	}

}
