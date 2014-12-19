package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientSpectate extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Client.SPECTATE;
    
    public WrapperPlayClientSpectate() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayClientSpectate(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve Target Player.
     * @return The current Target Player
     */
    public uuid getTargetPlayer() {
        return (uuid) handle.getSpecificModifier(UUID.class).read(0);
    }
    
    /**
     * Set Target Player.
     * @param value - new value.
     */
    public void setTargetPlayer(uuid value) {
        handle.getSpecificModifier(UUID.class).write(0, (UUID) value);
    }
    
}

