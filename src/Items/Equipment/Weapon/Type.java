package Items.Equipment.Weapon;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Type {
    
    BOW(        true,   Weight.LIGHT,   100,    100), 
    CROSSBOW(   true,   Weight.MEDIUM,  100,    100),
    AXE(        false,  Weight.MEDIUM,  100,    100), 
    MACE(       false,  Weight.HEAVY,   100,    100),
    HAMMER(     true,   Weight.HEAVY,   100,    100),
    SWORD(      false,  Weight.MEDIUM,  100,    100),
    LONGSWORD(  true,   Weight.HEAVY,   100,    100), 
    SHIELD(     false,  Weight.MEDIUM,  100,    100), 
    SPEAR(      false,  Weight.LIGHT,   100,    100), 
    DAGGER(     false,  Weight.LIGHT,   100,    100), 
    STAFF(      true,   Weight.LIGHT,   100,    100);
    
    private final boolean twoHands;
    private final Weight weight;
    private final int baseDamage;
    private final int durability;
    
    private Type(boolean hands, Weight weight, int damage, int durability) {
        this.twoHands = hands;
        this.weight = weight;
        this.baseDamage = damage;
        this.durability = durability;
    }
    
    public boolean isTwoHanded() {
        return twoHands;
    }
    
    public int getBaseDamage() {
        return baseDamage;
    }
    
    public Weight getWeight() {
        return weight;
    }
    
    public int getDurability() {
        return durability;
    }
    
    public static Type getRandomType() {
        return Type.values()[Randomizer.getRandomNumber(Type.values().length)];
    }
    
}
