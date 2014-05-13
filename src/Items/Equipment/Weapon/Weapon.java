package Items.Equipment.Weapon;

import Items.Equipment.Equipment;
import Items.Equipment.Weight;
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
        this.damage = this.calculateDamage(qual, type.getBaseDamage());
        super.setDurability(qual, type.getDurability());
        this.range = type.getRange(); //TODO range durch magie veraenderbar?
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
    
    private int calculateDamage(Quality qual, int dmg) {
        final int max;
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: max = dmg;     break;
            case EPIC:      max = dmg;     break;
            case RARE:      max = dmg;     break;
            case UNCOMMON:  max = dmg;     break;
            case COMMON:    max = dmg;     break;
            default:        assert false; max = 0;
        }
        final int min = max / 2;
        return min + Randomizer.getRandomNumber(((max - min) + 1));
    }
    
    @Override
    public String toString() {
        String str = "Range: " + range + "; Type: " + type + "; Quality: " + super.getQuality() + "; Damage: " + damage;
        return str;
    }

    @Override
    public Weight getWeight() {
        return type.getWeight();
    }

}
