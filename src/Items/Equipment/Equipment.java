package Items.Equipment;

import Items.Items;
import Items.Quality;
import Utilities.Randomizer;
import java.util.EnumMap;


public abstract class Equipment extends Items {
    
    private int currentDurability = 0;
    private int maxDurability = 0;
    //Map holding all the magical upgrades to this item
    private EnumMap<MagicAttribute, Integer> magic;
    //Map holding enhancements to the magic Attributes linked to it's quality
    private final static EnumMap<Quality, Integer> magicQBonus = new EnumMap<Quality, Integer>(Quality.class);
    
    static {
        magicQBonus.put(Quality.COMMON,      0);
        magicQBonus.put(Quality.UNCOMMON,    5);
        magicQBonus.put(Quality.RARE,        10);
        magicQBonus.put(Quality.EPIC,        15);
        magicQBonus.put(Quality.LEGENDARY,   20);
        magicQBonus.put(Quality.UNIQUE,      magicQBonus.get(Quality.LEGENDARY));
    }
    
    
    /**
     * returns the current durability
     * @return the current durability 
     */
    public final int getDurabilityCurrent() {
        return currentDurability;
    }
    
    /**
     * returns the maximum durability
     * @return the maximum durability 
     */
    public final int getDurabilityMax() {
        return maxDurability;
    }
    
    /**
     * repairs the object to it's "full health"
     */
    public final void repair() {
        currentDurability = maxDurability;
    }
    
    /**
     * repairs the object by a specified amount of points
     * @param points amount to repair
     */
    public final void repair(final int points) {
        currentDurability += points;
        if (currentDurability  > maxDurability) {
            this.repair();
        } 
    }
    
    /**
     * damages the item itself - if durability drops below 0, the item get's destroyed
     * @param dmg damage to deal
     */
    public final void damage(final int dmg) {
        currentDurability -= dmg;
        if (currentDurability <= 0) {
            //TODO destroy 
        }   
    }
    
    /**
     * returns the item's weight
     * @return the item's weight
     */
    public abstract Weight getWeight();
    
    /**
     * sets both durability values when created
     * Half the initial value is garanteed, the other half is random
     * @param durability initial value
     */
    protected final void setDurability(final int durability) {
        if (maxDurability == 0) {
            final int min = durability / 2;
            
            maxDurability = min + Randomizer.getRandomNumberNIncluded(durability - min);
            currentDurability = (int)(Math.max(maxDurability / 2, Randomizer.getRandomNumberNIncluded(maxDurability)));
        }
    }
    
    /**
     * Should only be called by the Builder!
     * sets the item's durability values
     * @param durability new value
     */
    protected final void setBuilderDurability(final int durability) {
        if (maxDurability == 0) {
            currentDurability = maxDurability = durability;
        }
    }
    
    /**
     * Generates a new magic attribute list, while taking the maximum amount and the magic quality into account
     * Certain Qualities garantee a certain degree of available slots
     * Furthermore the Quality adds a quality bonus to the magic value.
     * @param maxSlots - hightest possible amount of slots
     * @param qual Quality of the item
     */
    protected void setMagicAttributes(final int maxSlots, final Quality qual) {
        final EnumMap<MagicAttribute, Integer> magicMap = new EnumMap<MagicAttribute, Integer>(MagicAttribute.class);
        //Depending on the Quality we want to ensure a minimum of magic slots
        final int minSlots;
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: minSlots = maxSlots / 2; break;
            case EPIC:      minSlots = maxSlots / 3; break;
            case RARE:      minSlots = maxSlots / 4; break; 
            case UNCOMMON:  minSlots = 0;            break;
            case COMMON:    minSlots = 0;            break;
            default:        assert false; minSlots = 0;
        }
        final int slots = minSlots + Randomizer.getRandomNumberNIncluded(maxSlots - minSlots);
        for (int i = 0; i < slots; i++) {
            final MagicAttribute rndMagic = MagicAttribute.getRandomMagic();
            final int value = magicQBonus.get(qual) + Randomizer.getRandomNumberNIncluded(rndMagic.getStat());
            //If that magic attribute is contained, overwrite only if the value is better
            //in that case correct the slot value! (i--)
            if (magicMap.containsKey(rndMagic)) {
                if (magicMap.get(rndMagic) < value) {
                    magicMap.put(rndMagic, value);
                }
                i--;
            } else {
                magicMap.put(rndMagic, value);
            }
        }
        this.magic = magicMap;
    }
    
    /**
     * Should only be called by the Builder!
     * sets the item's magic attributes
     * No calculation - only handing over the reference
     * @param magic to be set
     */
    protected void setBuilderMagicAttributes(final EnumMap<MagicAttribute, Integer> magic) {
        this.magic = magic;
    }
    
    /**
     * returns the magic attribute map
     * @return the magic attribute map
     */
    public EnumMap<MagicAttribute, Integer> getMagicAttributes() {
        return this.magic.clone();
    }
    
}