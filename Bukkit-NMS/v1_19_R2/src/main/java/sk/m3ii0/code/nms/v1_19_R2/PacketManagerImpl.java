package sk.m3ii0.code.nms.v1_19_R2;

import sk.m3ii0.code.bukkit.spi.PacketManager;
import sk.m3ii0.code.bukkit.utils.Version;

public class PacketManagerImpl implements PacketManager {

    @Override
    public boolean isSupported(Version serverVersion) {
        return serverVersion.getPacketVersion().equals("1_19_R2");
    }

}