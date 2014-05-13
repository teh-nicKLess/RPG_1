package Items.Equipment.Accessory;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Slot {
    
    RING, BRACELET, NECKLACE;
    
    
    public static Weight getWeight() {
        return Weight.LIGHT;
    }
    
    public static Slot getRandomSlot() {
        return Slot.values()[Randomizer.getRandomNumber(Slot.values().length)];
    }
    
}
