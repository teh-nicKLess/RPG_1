package Items.Equipment.Accessory;

import Utilities.Randomizer;


public enum Material {
    
    RUBY((byte)     5), 
    SAPPHIRE((byte) 5), 
    GOLD((byte)     4), 
    SILVER((byte)   3),
    COPPER((byte)   2),
    BONE((byte)     1);
    
    
    private final int maxMagicSlots;
    
    
    private Material(final byte maxMagicSlots) {
        this.maxMagicSlots = maxMagicSlots;
    }
    
    
    protected final int getMaxMagicSlots() {
        return maxMagicSlots == 0 ? 0 : maxMagicSlots + 1;
    }
    
    public static Material getRandomSlot() {
        return Material.values()[Randomizer.getRandomNumber(Material.values().length)];
    }
}
