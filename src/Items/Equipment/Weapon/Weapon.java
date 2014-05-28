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
    //Holds the damageBonus values, depending on the item quality
    private static final EnumMap<Quality, Integer> damageBonus = new EnumMap<Quality, Integer>(Quality.class);
    //Holds all the weapon types names
    private static final EnumMap<Type, String> nameMap = new EnumMap<Type, String>(Type.class);
    
    static {
        //Enter the damageBonus values into the enumMap
        damageBonus.put(Quality.COMMON,       0);
        damageBonus.put(Quality.UNCOMMON,     5);
        damageBonus.put(Quality.RARE,         10);
        damageBonus.put(Quality.EPIC,         20);
        damageBonus.put(Quality.LEGENDARY,    25);
        damageBonus.put(Quality.UNIQUE,       damageBonus.get(Quality.LEGENDARY));
        
        //Fill both enumMaps with the name parts of the currentLocale
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
    
    /**
     * Get a completly random Weapon
     */
    public Weapon() {
        this(Type.getRandomType(), Quality.getRandomQuality());
    }
    
    /**
     * Get a random Weapon with a given Type
     * @param type to assign to the Weapon
     */
    public Weapon(final Type type) {
        this(type, Quality.getRandomQuality());
    }
    
    /**
     * Get a random Weapon with a given Quality
     * @param qual to assign to the Weapon
     */
    public Weapon(final Quality qual) {
        this(Type.getRandomType(), qual);
    }
    
    /**
     * Get a random Weapon with a given Type and Quality
     * @param type to assign to the Weapon
     * @param qual to assign to the Weapon 
     */
    public Weapon(final Type type, final Quality qual) {
        this.type = type;
        super.setQuality(qual);
        this.damage = this.calculateDamage(qual, type.getBaseDamage());
        super.setDurability(type.getDurability());
        this.range = type.getRange();
        super.setName(nameMap.get(type));
        super.setMagicAttributes(type.getMaxMagicSlots(), qual);
    }
    
    /**
     * returns the weapon's raw damage
     * @return the weapon's raw damage
     */
    public final int getDamage() {
        return damage;
    } 
    
    /**
     * returns the weapons total damage (raw + magic bonus)
     * @return the weapons total damage (raw + magic bonus) 
     */
    public final int getTotalDamage() {
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
    
    /**
     * returns the weapon's type
     * @return the weapon's type 
     */
    public final Type getType() {
        return type;
    }
    
    /**
     * returns the weapon's range
     * @return the weapon's range 
     */
    public final int getRange() {
        return range;
    }
    
    /**
     * returns true if the weapon is two handed 
     * @return true if the weapon is two handed
     */
    public final boolean isTwoHanded() {
        return type.isTwoHanded();
    }
    
    /*
     * calculates the weapon's random raw damage
     * weapon base value + quality Bonus is the upper bound
     * half that value is the lower round
     */
    private int calculateDamage(final Quality qual, final int dmg) {
        final int max = dmg + damageBonus.get(qual);
        final int min = max / 2;
        return min + Randomizer.getRandomNumberNIncluded((max - min));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("Name: "); sb.append(super.getName()); sb.append("\n");
        sb.append("Quality: "); sb.append(super.getQuality()); sb.append("\n");
        sb.append("C Durability: "); sb.append(super.getDurabilityCurrent()); sb.append("\n");
        sb.append("M Durability: "); sb.append(super.getDurabilityMax()); sb.append("\n");
        sb.append("Magic Attributes: "); sb.append(super.getMagicAttributes()); sb.append("\n");
        sb.append("Damage: "); sb.append(this.getDamage()); sb.append("\n");
        sb.append("TOTAL Damage: "); sb.append(this.getTotalDamage()); sb.append("\n");
        sb.append("Range: "); sb.append(this.getRange()); sb.append("\n");
        sb.append("Type: "); sb.append(this.getType()); sb.append("\n");
        return sb.toString();
    }

    /**
     * returns the object's weight
     * @return the object's weight 
     */
    @Override
    public final Weight getWeight() {
        return type.getWeight();
    }
    
    /**
     * If you wish to define every single attribute of the Weapon
     * the Builder class is your friend. Make sure you set every 
     * attribute before you call build().
     */
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
        /**
         * Sets the Weapon's name. Can be either a Name on it's own like "Mjölnir" 
         * -> set both booleans to false
         * Or you may use the internationalization files: translation = true. 
         * If the name is unique, unique must be set true.
         * @param name the String to set / lookup
         * @param translation set true if you wish to use the internationalization files
         * @param unique set true if the name to look up is in the UniqueItemNames file, 
         *              false: default Weapon file will be used
         * @return the builder object itself.
         */
        public Builder name(final String name, final boolean translation, final boolean unique) {
            this.name = name; 
            this.translation = translation; 
            this.unique = unique;
            return this; 
        }
        
        /**
         * Completes the Builder object to get the Weapon object
         * @return Weapon with the set attributes
         */
        public Weapon build() {
            return new Weapon(this);
        }
    }
    
    /**
     * Only called by the Builder.build() process
     * @param builder containing the information for the Weapon
     */
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
