package Items.Equipment.Armour;

import Utilities.Randomizer;

public enum Slot {
    
    HANDS((byte)1), FEET((byte)1), HEAD((byte)2), LEGS((byte)3), TORSO((byte)5);
    
    private final byte multiplier;

    private Slot(byte multiplier) {
        this.multiplier = multiplier;
    }

    public final byte getMultiplier() { 
        return multiplier; 
    }
    
    public static Slot getRandomSlot() {
        return Slot.values()[Randomizer.getRandomNumber(Slot.values().length)]; 
    }
        
}
