package Items.Equipment.Weapon;

import Items.Equipment.Weight;
import Utilities.Randomizer;

public enum Type {
    
    BOW(        true,   Weight.LIGHT,   180,    100,    50,     (byte)2), 
    CROSSBOW(   true,   Weight.MEDIUM,  200,    100,    50,     (byte)1),
    AXE(        false,  Weight.MEDIUM,  180,    100,    2,      (byte)2), 
    MACE(       false,  Weight.HEAVY,   200,    100,    2,      (byte)1),
    HAMMER(     true,   Weight.HEAVY,   195,    100,    3,      (byte)0),
    SWORD(      false,  Weight.MEDIUM,  170,    100,    2,      (byte)1),
    LONGSWORD(  true,   Weight.HEAVY,   190,    100,    3,      (byte)0), 
    SHIELD(     false,  Weight.MEDIUM,  125,    100,    1,      (byte)2), 
    SPEAR(      false,  Weight.LIGHT,   160,    100,    3,      (byte)1), 
    DAGGER(     false,  Weight.LIGHT,   150,    100,    1,      (byte)2), 
    STAFF(      true,   Weight.LIGHT,   175,    100,    4,      (byte)4);
    
    private final boolean twoHands;
    private final Weight weight;
    private final int baseDamage;
    private final int durability;
    private final int range;
    private final byte maxMagicSlots;
    
    private Type(final boolean hands, final Weight weight, final int damage, 
            final int durability, final int range, final byte maxMagicSlots) {
        this.twoHands = hands;
        this.weight = weight;
        this.baseDamage = damage;
        this.durability = durability;
        this.range = range;
        this.maxMagicSlots = maxMagicSlots;
    }
    
    /**
     * returns true if the weapon is two handed
     * @return true if the weapon is two handed
     */
    protected final boolean isTwoHanded() {
        return twoHands;
    }
    
    /**
     * returns the weapon's base damage value
     * @return the weapon's base damage value 
     */
    protected final int getBaseDamage() {
        return baseDamage;
    }
    
    /**
     * returns the weapon's weight
     * @return the weapon's weight 
     */
    protected final Weight getWeight() {
        return weight;
    }
    
    /**
     * returns the weapon's durability value
     * @return the weapon's durability value 
     */
    protected final int getDurability() {
        return durability;
    }
    
    /**
     * returns the weapon's range
     * @return the weapon's range
     */
    protected final int getRange() {
        return range;
    }
    
    /**
     * returns the weapon's maximum magical slots
     * @return the weapon's maximum magical slots
     */
    protected final int getMaxMagicSlots() {
        return maxMagicSlots;
    }
    
    /**
     * returns a random Type
     * @return a random Type
     */
    public static Type getRandomType() {
        return Type.values()[Randomizer.getRandomNumber(Type.values().length)];
    }
    
}
