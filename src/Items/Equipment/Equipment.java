package Items.Equipment;

import Items.Items;
import Items.Quality;
import Utilities.Randomizer;


public abstract class Equipment extends Items {
    
    private int currentDurability = 0;
    private int maxDurability = 0;
    
    
    public final int getDurabilityCurrent() {
        return currentDurability;
    }
    
    public final int getDurabilityMax() {
        return maxDurability;
    }
    
    protected final void setDurability(int hp) {
        if (maxDurability == 0) {
            maxDurability = hp;
            currentDurability = (int)(Math.max(0.5f * hp, Randomizer.getRandomNumber(hp + 1)));
            //TODO rethink
        }
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
    
    protected abstract int calculateHealth(Quality qual, int[] healthValues);
    
}