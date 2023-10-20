package io.github.andrew6rant.obfuscatedaccessibility;

import eu.midnightdust.lib.config.MidnightConfig;
import io.github.andrew6rant.obfuscatedaccessibility.config.Config;
import net.fabricmc.api.ClientModInitializer;

public class ObfuscatedAccessibilityClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MidnightConfig.init("obfuscatedaccessibility", Config.class);
	}
}