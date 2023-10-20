package io.github.andrew6rant.obfuscatedaccessibility.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class Config extends MidnightConfig {
    @Comment(centered = true) public static Comment immediate;
    @Entry(min = -1000000, max = 1000000) public static int glyphspeed = 500;
    @Comment(centered = true) public static Comment numspeed;

}
