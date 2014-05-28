package Items.Equipment;

import Utilities.Randomizer;


public enum MagicAttribute {
    
    ARMOUR(10), SPELLRESISTANCE(10), DAMAGEREDUCTION(5),
    WEAPONDAMAGE(10), SPELLDAMAGE(10), DAMAGE(5), 
    MOVEMENTSPEED(10), ATTACKSPEED(10), SPEED(5);
    
    
    private final int maxStat;
    
    private MagicAttribute(final int stat) {
        this.maxStat = stat;
    }
    
    /**
     * returns the base value of that magic
     * @return the base value of that magic
     */
    protected final int getStat() {
        return maxStat;
    }
    
    /**
     * returns a random Magic Attribute
     * @return a random Magic Attribute 
     */
    public static MagicAttribute getRandomMagic() {
        return MagicAttribute.values()[Randomizer.getRandomNumber(MagicAttribute.values().length)]; 
    }
    
}
