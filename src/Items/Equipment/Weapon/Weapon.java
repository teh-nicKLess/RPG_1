package Items.Equipment.Weapon;

import Items.Equipment.Equipment;
import Items.Equipment.MagicAttribute;
import Items.Equipment.Weight;
import Items.Quality;
import Utilities.Randomizer;
import java.util.EnumMap;
import java.util.ResourceBundle;


public final class Weapon extends Equipment {
    
    private final int damage;
    private final Type type;
    private final int range;
    private static final EnumMap<Quality, Integer> damageBonus = new EnumMap<Quality, Integer>(Quality.class);
    private static final EnumMap<Type, String> nameMap = new EnumMap<Type, String>(Type.class);
    
    static {
        
        damageBonus.put(Quality.COMMON,       0);
        damageBonus.put(Quality.UNCOMMON,     5);
        damageBonus.put(Quality.RARE,         10);
        damageBonus.put(Quality.EPIC,         20);
        damageBonus.put(Quality.LEGENDARY,    25);
        damageBonus.put(Quality.UNIQUE,       damageBonus.get(Quality.LEGENDARY));
        
        final ResourceBundle names = ResourceBundle.getBundle("Internationalization.Weapon", mygame.RPG_1.currentLocale);
        nameMap.put(Type.BOW,       names.getString("BOW"));
        nameMap.put(Type.CROSSBOW,  names.getString("CROSSBOW"));
        nameMap.put(Type.AXE,       names.getString("AXE"));
        nameMap.put(Type.MACE,      names.getString("MACE"));
        nameMap.put(Type.HAMMER,    names.getString("HAMMER"));
        nameMap.put(Type.SWORD,     names.getString("SWORD"));
        nameMap.put(Type.LONGSWORD, names.getString("LONGSWORD"));
        nameMap.put(Type.SHIELD,    names.getString("SHIELD"));
        nameMap.put(Type.SPEAR,     names.getString("SPEAR"));
        nameMap.put(Type.DAGGER,    names.getString("DAGGER"));
        nameMap.put(Type.STAFF,     names.getString("STAFF"));
    }
    
    public Weapon() {
        this(Type.getRandomType(), Quality.getRandomQuality());
    }
    
    public Weapon(final Type type) {
        this(type, Quality.getRandomQuality());
    }
    
    public Weapon(final Quality qual) {
        this(Type.getRandomType(), qual);
    }
        
    public Weapon(final Type type, final Quality qual) {
        this.type = type;
        super.setQuality(qual);
        this.damage = this.calculateDamage(qual, type.getBaseDamage());
        super.setDurability(qual, type.getDurability());
        this.range = type.getRange();
        super.setName(nameMap.get(type));
        super.setMagicAttributes(type.getMaxMagicSlots(), qual);
    }
    
    public final int getDamage() {
        int value = damage;
        final EnumMap<MagicAttribute, Integer> magic = super.getMagicAttributes();
        if (magic.containsKey(MagicAttribute.WEAPONDAMAGE)) {
            value += magic.get(MagicAttribute.WEAPONDAMAGE);
        }
        if (magic.containsKey(MagicAttribute.DAMAGE)) {
            value += magic.get(MagicAttribute.DAMAGE);
        }
        return value;
    } 
    
    public final Type getType() {
        return type;
    }
    
    public final int getRange() {
        return range;
    }
    
    public final boolean isTwoHanded() {
        return type.isTwoHanded();
    }
    
    private int calculateDamage(final Quality qual, final int dmg) {
        final int max = dmg + damageBonus.get(qual);
        final int min = max / 2;
        return min + Randomizer.getRandomNumber(((max - min) + 1));
    }
    
    @Override
    public String toString() {
        return "Range: " + range + "; Type: " + type + "; Quality: " + super.getQuality() + "; Damage: " + damage;
    }

    @Override
    public final Weight getWeight() {
        return type.getWeight();
    }
    
    public static class Builder {
        private int damage;
        private Type type;
        private int range;
        private String name;
        private boolean translation;
        private boolean unique;
        private Quality qual;
        private int durability;
        private EnumMap<MagicAttribute, Integer> magic;
        
        public Builder damage(final int damage){this.damage = damage; return this; }
        public Builder type(final Type type){this.type = type; return this; }
        public Builder range(final int range){this.range = range; return this; }
        public Builder quality(final Quality qual){this.qual = qual; return this; }
        public Builder magic(final MagicAttribute magicAttribute, final int value){this.magic.put(magicAttribute, value); return this; }
        public Builder durability(final int durability){this.durability = durability; return this; }
        public Builder name(final String name, final boolean translation, final boolean unique) {
            this.name = name; 
            this.translation = translation; 
            this.unique = unique;
            return this; 
        }
        
        
        public Weapon build() {
            return new Weapon(this);
        }
    }
    
    private Weapon(final Builder builder) {
        this.damage = builder.damage;
        this.range = builder.range;
        this.type = builder.type;
        super.setBuilderDurability(builder.durability);
        super.setQuality(builder.qual);
        super.setBuilderMagicAttributes(builder.magic);
        if (builder.translation) {
            final ResourceBundle name;
            if (builder.unique) {
                name = ResourceBundle.getBundle("Internationalization.UniqueItemNames", mygame.RPG_1.currentLocale);
            } else {
                name = ResourceBundle.getBundle("Internationalization.Weapon", mygame.RPG_1.currentLocale);
            }
            super.setName(name.getString(builder.name));
        } else {
            super.setName(builder.name);
        }
    }

}
