package sk.m3ii0.code.bukkit.spi;

import sk.m3ii0.code.bukkit.utils.Version;

public interface PacketManager {

    // Support depend
    boolean isSupported(Version serverVersion);

}
