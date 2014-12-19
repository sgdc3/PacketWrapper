package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSetSlot extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.SET_SLOT;
    
    public WrapperPlayServerSetSlot() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayServerSetSlot(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve Window ID.
     * <p>
     * Notes: the window which is being updated. 0 for player inventory. Note that all known window types include the player inventory. This packet will only be sent for the currently opened window while the player is performing actions, even if it affects the player inventory. After the window is closed, a number of these packets are sent to update the player's inventory window (0).
     * @return The current Window ID
     */
    public byte getWindowId() {
        return (byte) handle.getIntegers().read(0);
    }
    
    /**
     * Set Window ID.
     * @param value - new value.
     */
    public void setWindowId(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve Slot.
     * <p>
     * Notes: the slot that should be updated
     * @return The current Slot
     */
    public short getSlot() {
        return (short) handle.getIntegers().read(1);
    }
    
    /**
     * Set Slot.
     * @param value - new value.
     */
    public void setSlot(short value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve Slot data.
     * @return The current Slot data
     */
    public ItemStack getSlotData() {
        return handle.getItemModifier().read(0);
    }
    
    /**
     * Set Slot data.
     * @param value - new value.
     */
    public void setSlotData(ItemStack value) {
        handle.getItemModifier().write(0, value);
    }
    
}

