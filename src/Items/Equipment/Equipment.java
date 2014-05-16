package Items.Equipment;

import Items.Items;
import Items.Quality;
import Utilities.Randomizer;
import java.util.EnumMap;


public abstract class Equipment extends Items {
    
    private int currentDurability = 0;
    private int maxDurability = 0;
    private EnumMap<MagicAttribute, Integer> magic;
    private final static EnumMap<Quality, Integer> magicQBonus = new EnumMap<Quality, Integer>(Quality.class);
    
    static {
        
        magicQBonus.put(Quality.COMMON,      0);
        magicQBonus.put(Quality.UNCOMMON,    5);
        magicQBonus.put(Quality.RARE,        10);
        magicQBonus.put(Quality.EPIC,        15);
        magicQBonus.put(Quality.LEGENDARY,   20);
        magicQBonus.put(Quality.UNIQUE,      magicQBonus.get(Quality.LEGENDARY));
    }
    
    
    public final int getDurabilityCurrent() {
        return currentDurability;
    }
    
    public final int getDurabilityMax() {
        return maxDurability;
    }
    
    public final void repair() {
        currentDurability = maxDurability;
    }
    
    public final void repair(int points) {
        currentDurability += points;
        if (currentDurability  > maxDurability) {
            this.repair();
        } 
    }
    
    public final void damage(int dmg) {
        currentDurability -= dmg;
        if (currentDurability <= 0) {
            //TODO destroy 
        }   
    }
    
    public abstract Weight getWeight();
    
    protected final void setDurability(Quality qual, final int durability) {
        if (maxDurability == 0) {
            final int min = durability / 2;
            
            maxDurability = min + Randomizer.getRandomNumber(((durability - min) + 1));
            currentDurability = (int)(Math.max(maxDurability / 2, Randomizer.getRandomNumber(maxDurability + 1)));
        }
    }
    
    protected void setMagicAttributes(final int maxSlots, final Quality qual) {
        final EnumMap<MagicAttribute, Integer> magicMap = new EnumMap<MagicAttribute, Integer>(MagicAttribute.class);
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
        final int slots = minSlots + Randomizer.getRandomNumber(maxSlots - minSlots);
        for (int i = 0; i < slots; i++) {
            final MagicAttribute rndMagic = MagicAttribute.getRandomMagic();
            final int value = magicQBonus.get(qual) + Randomizer.getRandomNumber(rndMagic.getStat());
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
    
    public EnumMap<MagicAttribute, Integer> getMagicAttributes() {
        return this.magic.clone();
    }
    
}