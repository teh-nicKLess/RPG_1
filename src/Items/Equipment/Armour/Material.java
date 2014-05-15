package Items.Equipment.Armour;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Material {
    
    WOOL(       5,      100,    Weight.LIGHT,   4), 
    SILK(       5,      100,    Weight.LIGHT,   4), 
    LEATHER(    10,     150,    Weight.MEDIUM,  3), 
    CHAINMAIL(  15,     150,    Weight.MEDIUM,  2), 
    IRON(       20,     200,    Weight.HEAVY,   1), 
    STEEL(      30,     200,    Weight.HEAVY,   0);
    
    
    private final int baseValue;
    private final int durability;
    private final Weight weight;
    private final int maxMagicSlots;
    
    private Material(int value, int durability, Weight weight, int maxMagicSlots) {
        this.baseValue = value;
        this.durability = durability;
        this.weight = weight;
        this.maxMagicSlots = maxMagicSlots + 1;
    }
    
    public final Weight getWeight() {
        return weight;
    }
    
    public final int getBaseValue() {
        return baseValue;
    }
    
    public final int getDurability() {
        return durability;
    }
    
    public final int getMaxMagicSlots() {
        return maxMagicSlots;
    }
    
    public static Material getRandomMaterial() {
        return Material.values()[Randomizer.getRandomNumber(Material.values().length)];
    } 
    
}
