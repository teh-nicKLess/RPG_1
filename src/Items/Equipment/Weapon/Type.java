package Items.Equipment.Weapon;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Type {
    
    BOW(        true,   Weight.LIGHT,   180,    100,    50), 
    CROSSBOW(   true,   Weight.MEDIUM,  200,    100,    50),
    AXE(        false,  Weight.MEDIUM,  180,    100,    2), 
    MACE(       false,  Weight.HEAVY,   200,    100,    2),
    HAMMER(     true,   Weight.HEAVY,   195,    100,    3),
    SWORD(      false,  Weight.MEDIUM,  170,    100,    2),
    LONGSWORD(  true,   Weight.HEAVY,   190,    100,    3), 
    SHIELD(     false,  Weight.MEDIUM,  125,    100,    1), 
    SPEAR(      false,  Weight.LIGHT,   160,    100,    3), 
    DAGGER(     false,  Weight.LIGHT,   150,    100,    1), 
    STAFF(      true,   Weight.LIGHT,   175,    100,    4);
    
    private final boolean twoHands;
    private final Weight weight;
    private final int baseDamage;
    private final int durability;
    private final int range;
    
    private Type(boolean hands, Weight weight, int damage, int durability, int range) {
        this.twoHands = hands;
        this.weight = weight;
        this.baseDamage = damage;
        this.durability = durability;
        this.range = range;
    }
    
    public final boolean isTwoHanded() {
        return twoHands;
    }
    
    public final int getBaseDamage() {
        return baseDamage;
    }
    
    public final Weight getWeight() {
        return weight;
    }
    
    public final int getDurability() {
        return durability;
    }
    
    public final int getRange() {
        return range;
    }
    
    public static Type getRandomType() {
        return Type.values()[Randomizer.getRandomNumber(Type.values().length)];
    }
    
    public static Type getRandomMaterial() {
        return Type.values()[Randomizer.getRandomNumber(Type.values().length)];
    }
    
}
