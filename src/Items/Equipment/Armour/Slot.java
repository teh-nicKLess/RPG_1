package Items.Equipment.Armour;

import Utilities.Randomizer;

public enum Slot {
    
    HANDS((byte)1), FEET((byte)1), HEAD((byte)2), LEGS((byte)3), TORSO((byte)5);
    
    private final byte multiplier;

    private Slot(final byte multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * returns the slot's multiplier value for armour calculation
     * @return the slot's multiplier value for armour calculation
     */
    protected final byte getMultiplier() { 
        return multiplier; 
    }
    
    /**
     * returns a random Slot
     * @return a random Slot
     */
    public static Slot getRandomSlot() {
        return Slot.values()[Randomizer.getRandomNumber(Slot.values().length)]; 
    }
        
}
