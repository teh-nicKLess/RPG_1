package Items.Equipment.Accessory;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Slot {
    
    RING, BRACELET, NECKLACE;
    
    
    private final int maxMagicSlots = 4;
    private final int durability = 200;
    
    
    public final int getMaxMagicSlots() {
        return maxMagicSlots == 0 ? 0 : maxMagicSlots + 1;
    }
    
    public final int getDurability() {
        return durability;
    }
    
    public Weight getWeight() {
        return Weight.NULL;
    }
    
    public static Slot getRandomSlot() {
        return Slot.values()[Randomizer.getRandomNumber(Slot.values().length)];
    }
    
}
