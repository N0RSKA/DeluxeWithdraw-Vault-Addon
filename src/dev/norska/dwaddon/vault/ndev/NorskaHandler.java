package dev.norska.dwaddon.vault.ndev;

import dev.norska.dwaddon.vault.ndev.handlers.CacheHandler;
import dev.norska.dwaddon.vault.ndev.handlers.ConfigHandler;
import lombok.Getter;

public class NorskaHandler {
	
	@Getter private CacheHandler cacheHandler = new CacheHandler();
	@Getter private ConfigHandler configurationHandler = new ConfigHandler();;

}
