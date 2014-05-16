package Items.Equipment.Armour;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Material {
    
    WOOL(       5,      20,     100,    Weight.LIGHT,   4), 
    SILK(       5,      20,     100,    Weight.LIGHT,   4), 
    LEATHER(    10,     15,     150,    Weight.MEDIUM,  3), 
    CHAINMAIL(  15,     10,     150,    Weight.MEDIUM,  2), 
    IRON(       20,     5,      200,    Weight.HEAVY,   1), 
    STEEL(      30,     0,      200,    Weight.HEAVY,   0);
    
    
    private final int physicalValue;
    private final int magicalValue;
    private final int durability;
    private final Weight weight;
    private final int maxMagicSlots;
    
    private Material(final int physicalValue, final int magicalValue, 
            final int durability, final Weight weight, final int maxMagicSlots) {
        this.physicalValue = physicalValue;
        this.magicalValue = magicalValue;
        this.durability = durability;
        this.weight = weight;
        this.maxMagicSlots = maxMagicSlots;
    }
    
    public final Weight getWeight() {
        return weight;
    }
    
    public final int getPhysicalValue() {
        return physicalValue;
    }
    
    public final int getMagicalValue() {
        return magicalValue;
    }
    
    public final int getDurability() {
        return durability;
    }
    
    public final int getMaxMagicSlots() {
        return maxMagicSlots == 0 ? 0 : maxMagicSlots + 1;
    }
    
    public static Material getRandomMaterial() {
        return Material.values()[Randomizer.getRandomNumber(Material.values().length)];
    } 
    
}
