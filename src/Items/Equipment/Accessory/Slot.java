package Items.Equipment.Accessory;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Slot {
    
    RING, BRACELET, NECKLACE;
    
    
    private final short durability = 200;
    
    /**
     * returns the durability
     * @return the durability
     */
    protected final int getDurability() {
        return durability;
    }
    
    /**
     * returns the weight
     * @return the weight 
     */
    protected Weight getWeight() {
        return Weight.NULL;
    }
    
    /**
     * returns a random Slot object
     * @return a random Slot object 
     */
    public static Slot getRandomSlot() {
        return Slot.values()[Randomizer.getRandomNumber(Slot.values().length)];
    }
    
}
