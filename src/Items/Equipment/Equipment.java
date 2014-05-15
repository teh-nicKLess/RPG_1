package Items.Equipment;

import Items.Items;
import Items.Quality;
import Utilities.Randomizer;
import java.util.Collections;
import java.util.EnumMap;


public abstract class Equipment extends Items {
    
    private int currentDurability = 0;
    private int maxDurability = 0;
    private EnumMap<MagicAttribute, Integer> magic;
    
    
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
    //TODO public abstract MagicAttribute getMagic();
    
    protected final void setDurability(Quality qual, int durability) {
        if (maxDurability == 0) {
            final int max;
            switch (qual) {
                case UNIQUE:
                case LEGENDARY: max = durability * 5; break;
                case EPIC:      max = durability * 4; break;
                case RARE:      max = durability * 3; break; 
                case UNCOMMON:  max = durability * 2; break;
                case COMMON:    max = durability; break;
                default:        assert false; max = 0;
            }
            final int min = max / 2;
            
            maxDurability = min + Randomizer.getRandomNumber(((max - min) + 1));
            currentDurability = (int)(Math.max(0.5f * maxDurability, Randomizer.getRandomNumber(maxDurability + 1)));
        }
    }
    
    protected void setMagicAttributes(int slots, Quality qual) {
        final EnumMap<MagicAttribute, Integer> magicMap = new EnumMap<MagicAttribute, Integer>(MagicAttribute.class);
        final int qualityBonus;
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: qualityBonus = 25; break;
            case EPIC:      qualityBonus = 20; break;
            case RARE:      qualityBonus = 15; break; 
            case UNCOMMON:  qualityBonus = 5;  break;
            case COMMON:    qualityBonus = 0;  break;
            default:        assert false; qualityBonus = 0;
        }
        for (int i = 0; i < slots; i++) {
            final MagicAttribute rndMagic = MagicAttribute.getRandomMagic();
            magicMap.put(rndMagic, Randomizer.getRandomNumber(rndMagic.getStat() + qualityBonus));
        }
        this.magic = (EnumMap) Collections.unmodifiableMap(magicMap);
    }
    
    public EnumMap<MagicAttribute, Integer> getMagicAttributes() {
        return this.magic;
    }
    
}