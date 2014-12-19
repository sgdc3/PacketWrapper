package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerGameStateChange extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.GAME_STATE_CHANGE;
    
    public WrapperPlayServerGameStateChange() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayServerGameStateChange(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve Reason.
     * @return The current Reason
     */
    public byte getReason() {
        return (byte) handle.getIntegers().read(0);
    }
    
    /**
     * Set Reason.
     * @param value - new value.
     */
    public void setReason(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve Value.
     * <p>
     * Notes: depends on reason
     * @return The current Value
     */
    public float getValue() {
        return handle.getFloat().read(0);
    }
    
    /**
     * Set Value.
     * @param value - new value.
     */
    public void setValue(float value) {
        handle.getFloat().write(0, value);
    }
    
}

