package Items.Equipment.Weapon;

import Items.Equipment.Equipment;
import Items.Quality;
import Utilities.Randomizer;


public final class Weapon extends Equipment {
    
    private final int damage;
    private final Type type;
    private final int range;
    
    
    public Weapon() {
        this(Type.getRandomType(), Quality.getRandomQuality());
    }
    
    public Weapon(Type type) {
        this(type, Quality.getRandomQuality());
    }
    
    public Weapon(Quality qual) {
        this(Type.getRandomType(), qual);
    }
        
    public Weapon(Type type, Quality qual) {
        this.type = type;
        super.setQuality(qual);
        this.damage = this.calculateDamage(qual, WeaponValues.getDamage(type));
        super.setDurability(this.calculateHealth(qual, WeaponValues.getHP()));
        this.range = 100;
        //TODO super.setName();
    }
    
    public final int getDamage() {
        return damage;
    } 
    
    public final Type getType() {
        return type;
    }
    
    public final int getRange() {
        return range;
    }
    
    private int calculateDamage(Quality qual, int[] dmgValues) {
        final int max;
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: max = dmgValues[4];     break;
            case EPIC:      max = dmgValues[3];     break;
            case RARE:      max = dmgValues[2];     break;
            case UNCOMMON:  max = dmgValues[1];     break;
            case COMMON:    max = dmgValues[0];     break;
            default:        assert false; max = 0;
        }
        final int min = max / 2;
        return min + Randomizer.getRandomNumber(((max - min) + 1));
    }

    protected final int calculateHealth(Quality qual, int[] healthValues) {
        int hp = Randomizer.getRandomNumber(51);
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: hp += healthValues[4];     break;
            case EPIC:      hp += healthValues[3];     break;
            case RARE:      hp += healthValues[2];     break;
            case UNCOMMON:  hp += healthValues[1];     break;
            case COMMON:    hp += healthValues[0];     break;
            default:        assert false; hp = 0;
        }
        return hp;
    }
}
