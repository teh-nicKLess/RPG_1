package Items.Equipment.Armour;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Material {
    
    WOOL(       5,      20,     100,    Weight.LIGHT,   (byte)4), 
    SILK(       5,      20,     100,    Weight.LIGHT,   (byte)4), 
    LEATHER(    10,     15,     150,    Weight.MEDIUM,  (byte)3), 
    CHAINMAIL(  15,     10,     150,    Weight.MEDIUM,  (byte)2), 
    IRON(       20,     5,      200,    Weight.HEAVY,   (byte)1), 
    STEEL(      30,     0,      200,    Weight.HEAVY,   (byte)0);
    
    
    private final int physicalValue;
    private final int magicalValue;
    private final int durability;
    private final Weight weight;
    private final byte maxMagicSlots;
    
    private Material(final int physicalValue, final int magicalValue, 
            final int durability, final Weight weight, final byte maxMagicSlots) {
        this.physicalValue = physicalValue;
        this.magicalValue = magicalValue;
        this.durability = durability;
        this.weight = weight;
        this.maxMagicSlots = maxMagicSlots;
    }
    
    /**
     * returns the material's weight
     * @return the material's weight 
     */
    protected final Weight getWeight() {
        return weight;
    }
    
    /**
     * returns the material's base physical armour value
     * @return the material's base physical armour value 
     */
    protected final int getPhysicalValue() {
        return physicalValue;
    }
    
    /**
     * returns the material's base magical armour value
     * @return the material's base magical armour value 
     */
    protected final int getMagicalValue() {
        return magicalValue;
    }
    
    /**
     * returns the material's base durability value
     * @return the material's base durability value
     */
    protected final int getDurability() {
        return durability;
    }
    
    /**
     * returns the material's maxímum allowed magical attribute slots
     * @return the material's maxímum allowed magical attribute slots
     */
    protected final int getMaxMagicSlots() {
        return maxMagicSlots;
    }
    
    /**
     * returns a random Material
     * @return a random Material
     */
    public static Material getRandomMaterial() {
        return Material.values()[Randomizer.getRandomNumber(Material.values().length)];
    } 
    
}
