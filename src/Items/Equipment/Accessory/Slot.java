package Items.Equipment.Accessory;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Slot {
    
    RING, BRACELET, NECKLACE;
    
    
    private final short durability = 200;
    
    
    protected final int getDurability() {
        return durability;
    }
    
    protected Weight getWeight() {
        return Weight.NULL;
    }
    
    public static Slot getRandomSlot() {
        return Slot.values()[Randomizer.getRandomNumber(Slot.values().length)];
    }
    
}
