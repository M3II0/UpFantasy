package sk.m3ii0.code.bukkit.api;

import org.bukkit.Bukkit;

public enum Version {

    V1_8(8, "1.8", "1_8_R1", "1.8-R0.1-SNAPSHOT"),
    V1_8_1(8, "1.8.1", "1_8_R1", "1.8-R0.1-SNAPSHOT"),
    V1_8_2(8, "1.8.2", "1_8_R1", "1.8-R0.1-SNAPSHOT"),
    V1_8_3(8, "1.8.3", "1_8_R2", "1.8.3-R0.1-SNAPSHOT"),
    V1_8_4(8, "1.8.4", "1_8_R3", "1.8.8-R0.1-SNAPSHOT"),
    V1_8_5(8, "1.8.5", "1_8_R3", "1.8.8-R0.1-SNAPSHOT"),
    V1_8_6(8, "1.8.6", "1_8_R3", "1.8.8-R0.1-SNAPSHOT"),
    V1_8_7(8, "1.8.7", "1_8_R3", "1.8.8-R0.1-SNAPSHOT"),
    V1_8_8(8, "1.8.8", "1_8_R3", "1.8.8-R0.1-SNAPSHOT"),
    V1_8_9(8, "1.8.9", "1_8_R3", "1.8.8-R0.1-SNAPSHOT"),
    V_1_9(9, "1.9", "1_9_R1", "1.9-R0.1-SNAPSHOT"),
    V_1_9_1(9, "1.9.1", "1_9_R1", "1.9-R0.1-SNAPSHOT"),
    V_1_9_2(9, "1.9.2", "1_9_R1", "1.9.2-R0.1-SNAPSHOT"),
    V_1_9_3(9, "1.9.3", "1_9_R1", "1.9.2-R0.1-SNAPSHOT"),
    V_1_9_4(9, "1.9.4", "1_9_R2", "1.9.4-R0.1-SNAPSHOT"),
    V_1_10(10, "1.10", "1_10_R1", "1.10.2-R0.1-SNAPSHOT"),
    V_1_10_1(10, "1.10.1", "1_10_R1", "1.10.2-R0.1-SNAPSHOT"),
    V_1_10_2(10, "1.10.2", "1_10_R1", "1.10.2-R0.1-SNAPSHOT"),
    V_1_11(11, "1.11", "1_11_R1", "1.11-R0.1-SNAPSHOT"),
    V_1_11_1(11, "1.11.1", "1_11_R1", "1.11.2-R0.1-SNAPSHOT"),
    V_1_11_2(11, "1.11.2", "1_11_R1", "1.11.2-R0.1-SNAPSHOT"),
    V_1_12(12, "1.12", "1_12_R1", "1.12-R0.1-SNAPSHOT"),
    V_1_12_1(12, "1.12.1", "1_12_R1", "1.12.1-R0.1-SNAPSHOT"),
    V_1_12_2(12, "1.12.2", "1_12_R1", "1.12.2-R0.1-SNAPSHOT"),
    V_1_13(13, "1.13", "1_13_R1", "1.13-R0.1-SNAPSHOT"),
    V_1_13_1(13, "1.13.1", "1_13_R2", "1.13.1-R0.1-SNAPSHOT"),
    V_1_13_2(13, "1.13.2", "1_13_R2", "1.13.2-R0.1-SNAPSHOT"),
    V_1_14(14, "1.14", "1_14_R1", "1.14-R0.1-SNAPSHOT"),
    V_1_14_1(14, "1.14.1", "1_14_R1", "1.14.1-R0.1-SNAPSHOT"),
    V_1_14_2(14, "1.14.2", "1_14_R1", "1.14.2-R0.1-SNAPSHOT"),
    V_1_14_3(14, "1.14.3", "1_14_R1", "1.14.3-R0.1-SNAPSHOT"),
    V_1_14_4(14, "1.14.4", "1_14_R1", "1.14.4-R0.1-SNAPSHOT"),
    V_1_15(15, "1.15", "1_15_R1", "1.15-R0.1-SNAPSHOT"),
    V_1_15_1(15, "1.15.1", "1_15_R1", "1.15.1-R0.1-SNAPSHOT"),
    V_1_15_2(15, "1.15.2", "1_15_R1", "1.15.2-R0.1-SNAPSHOT"),
    V_1_16(16, "1.16", "1_16_R1", "1.16.1-R0.1-SNAPSHOT"),
    V_1_16_1(16, "1.16.1", "1_16_R1", "1.16.1-R0.1-SNAPSHOT"),
    V_1_16_2(16, "1.16.2", "1_16_R2", "1.16.2-R0.1-SNAPSHOT"),
    V_1_16_3(16, "1.16.3", "1_16_R2", "1.16.3-R0.1-SNAPSHOT"),
    V_1_16_4(16, "1.16.4", "1_16_R3", "1.16.4-R0.1-SNAPSHOT"),
    V_1_16_5(16, "1.16.5", "1_16_R3", "1.16.5-R0.1-SNAPSHOT"),
    V_1_17(17, "1.17", "1_17_R1", "1.17-R0.1-SNAPSHOT"),
    V_1_17_1(17, "1.17.1", "1_17_R1", "1.17.1-R0.1-SNAPSHOT"),
    V_1_18(18, "1.18", "1_18_R1", "1.18-R0.1-SNAPSHOT"),
    V_1_18_1(18, "1.18.1", "1_18_R1", "1.18.1-R0.1-SNAPSHOT"),
    V_1_18_2(18, "1.18.2", "1_18_R2", "1.18.2-R0.1-SNAPSHOT"),
    V_1_19(19, "1.19", "1_19_R1", "1.19-R0.1-SNAPSHOT"),
    V_1_19_1(19, "1.19.1", "1_19_R1", "1.19.1-R0.1-SNAPSHOT"),
    V_1_19_2(19, "1.19.2", "1_19_R1", "1.19.2-R0.1-SNAPSHOT"),
    V_1_19_3(19, "1.19.3", "1_19_R2", "1.19.3-R0.1-SNAPSHOT");

    Version(int raw, String name, String packetVersion, String bukkitVersion) {
        this.raw = raw;
        this.name = name;
        this.packetVersion = packetVersion;
        this.bukkitVersion = bukkitVersion;
    }

    private final int raw;
    private final String name;
    private final String packetVersion;
    private final String bukkitVersion;

    // Get raw int version
    public int getRaw() {
        return raw;
    }

    // Is version contains RGB?
    public boolean isContainsRgb() {
        return raw > 15;
    }

    // Bukkit version
    public String getBukkitVersion() {
        return bukkitVersion;
    }

    // Packet version
    public String getPacketVersion() {
        return packetVersion;
    }

    // Version name
    public String getName() {
        return name;
    }

    // Returns server version
    public static Version getServerVersion() {
        for (Version version : Version.values()) {
            if (version.getName().equals(Bukkit.getVersion().split("MC:")[1].replace(")", "").replace(" ", ""))) return version;
        }
        return null;
    }

}
