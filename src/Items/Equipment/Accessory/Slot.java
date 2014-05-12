package Items.Equipment.Accessory;

import Utilities.Randomizer;

public enum Slot {
    
    RING, BRACELET, NECKLACE;
    
    public static Slot getRandomSlot() {
        return Slot.values()[Randomizer.getRandomNumber(Slot.values().length)];
    }
    
}
