package Items.Equipment.Armour;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Material {
    
    WOOL(       20,     100,    Weight.LIGHT), 
    SILK(       20,     100,    Weight.LIGHT), 
    LEATHER(    45,     150,    Weight.MEDIUM), 
    CHAINMAIL(  50,     150,    Weight.MEDIUM), 
    IRON(       75,     200,    Weight.HEAVY), 
    STEEL(      100,    200,    Weight.HEAVY);
    
    
    private final int baseValue;
    private final int durability;
    private final Weight weight;
    
    private Material(int value, int durability, Weight weight) {
        this.baseValue = value;
        this.durability = durability;
        this.weight = weight;
    }
    
    public Weight getWeight() {
        return weight;
    }
    
    public int getBaseValue() {
        return baseValue;
    }
    
    public int getDurability() {
        return durability;
    }
    
    public static Material getRandomType() {
        return Material.values()[Randomizer.getRandomNumber(Material.values().length)];
    } 
    
}
