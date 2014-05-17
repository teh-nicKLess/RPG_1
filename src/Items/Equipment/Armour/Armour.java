package Items.Equipment.Armour;

import Items.Equipment.Equipment;
import Items.Equipment.MagicAttribute;
import Items.Equipment.Weight;
import Items.Quality;
import Utilities.Randomizer;
import java.util.EnumMap;
import java.util.ResourceBundle;


public final class Armour extends Equipment {
    
    private final int physicalArmour;
    private final int magicalArmour;
    private final Slot slot;
    private final Material mat;
    //Map which hold the physical armour bonus linked to it's quality
    private final static EnumMap<Quality, Integer> physicalBonus = new EnumMap<Quality, Integer>(Quality.class);
    //Map which hold the magical armour bonus linked to it's quality
    private final static EnumMap<Quality, Integer> magicalBonus = new EnumMap<Quality, Integer>(Quality.class);
    //Map holding the material part names
    private final static EnumMap<Material, String> nameMat = new EnumMap<Material, String>(Material.class);
    //Double Map holding the slot part names, linked to the weight
    private final static EnumMap<Weight, EnumMap<Slot, String>> nameSlot = new EnumMap<Weight, EnumMap<Slot, String>>(Weight.class);
    
    static {
        //Filling in physical armour bonus values
        physicalBonus.put(Quality.COMMON,       0);
        physicalBonus.put(Quality.UNCOMMON,     5);
        physicalBonus.put(Quality.RARE,         10);
        physicalBonus.put(Quality.EPIC,         20);
        physicalBonus.put(Quality.LEGENDARY,    25);
        physicalBonus.put(Quality.UNIQUE,       physicalBonus.get(Quality.LEGENDARY));
        
        //Filling in magical armour bonus values
        magicalBonus.put(Quality.COMMON,        0);
        magicalBonus.put(Quality.UNCOMMON,      5);
        magicalBonus.put(Quality.RARE,          10);
        magicalBonus.put(Quality.EPIC,          20);
        magicalBonus.put(Quality.LEGENDARY,     25);
        magicalBonus.put(Quality.UNIQUE,        magicalBonus.get(Quality.LEGENDARY));
        
        final ResourceBundle names = ResourceBundle.getBundle("Internationalization.Armour", mygame.RPG_1.currentLocale);
        nameMat.put(Material.WOOL,      names.getString("WOOL"));
        nameMat.put(Material.SILK,      names.getString("SILK"));
        nameMat.put(Material.CHAINMAIL, names.getString("CHAINMAIL"));
        nameMat.put(Material.LEATHER,   names.getString("LEATHER"));
        nameMat.put(Material.IRON,      names.getString("IRON"));
        nameMat.put(Material.STEEL,     names.getString("STEEL"));
        
        EnumMap<Slot, String> nameSlotLight = new EnumMap<Slot, String>(Slot.class);
        nameSlotLight.put(Slot.HANDS,   names.getString("HANDS_light"));
        nameSlotLight.put(Slot.FEET,    names.getString("FEET_light"));
        nameSlotLight.put(Slot.LEGS,    names.getString("LEGS_light"));
        nameSlotLight.put(Slot.HEAD,    names.getString("HEAD_light"));
        nameSlotLight.put(Slot.TORSO,   names.getString("TORSO_light"));
        
        EnumMap<Slot, String> nameSlotMedium = new EnumMap<Slot, String>(Slot.class);
        nameSlotMedium.put(Slot.HANDS,  names.getString("HANDS_medium"));
        nameSlotMedium.put(Slot.FEET,   names.getString("FEET_medium"));
        nameSlotMedium.put(Slot.LEGS,   names.getString("LEGS_medium"));
        nameSlotMedium.put(Slot.HEAD,   names.getString("HEAD_medium"));
        nameSlotMedium.put(Slot.TORSO,  names.getString("TORSO_medium"));
        
        EnumMap<Slot, String> nameSlotHeavy = new EnumMap<Slot, String>(Slot.class);
        nameSlotHeavy.put(Slot.HANDS,   names.getString("HANDS_heavy"));
        nameSlotHeavy.put(Slot.FEET,    names.getString("FEET_heavy"));
        nameSlotHeavy.put(Slot.LEGS,    names.getString("LEGS_heavy"));
        nameSlotHeavy.put(Slot.HEAD,    names.getString("HEAD_heavy"));
        nameSlotHeavy.put(Slot.TORSO,   names.getString("TORSO_heavy"));
        
        nameSlot.put(Weight.HEAVY, nameSlotHeavy);
        nameSlot.put(Weight.MEDIUM, nameSlotMedium);
        nameSlot.put(Weight.LIGHT, nameSlotLight);
    }
    
    /**
     * Get a completly random Armour
     */
    public Armour() {
        this(Material.getRandomMaterial(), Slot.getRandomSlot(), Quality.getRandomQuality());
    }
    
    /**
     * Get a random Armour with a given Material
     * @param mat to assign to the Armour
     */
    public Armour(final Material mat) {
        this(mat, Slot.getRandomSlot(), Quality.getRandomQuality());
    }
    
    /**
     * Get a random Armour with a given Slot
     * @param slot to assign to the Armour
     */
    public Armour(final Slot slot) {
        this(Material.getRandomMaterial(), slot, Quality.getRandomQuality());
    }
    
    /**
     * Get a random Armour with a given Quality
     * @param qual to assign to the Armour
     */
    public Armour(final Quality qual) {
        this(Material.getRandomMaterial(), Slot.getRandomSlot(), qual);
    }
    
    /**
     * Get a random Armour with a given Material and Slot
     * @param mat to assign to the Armour
     * @param slot to assign to the Armour
     */
    public Armour(final Material mat, final Slot slot) {
        this(mat, slot, Quality.getRandomQuality());
    }
    
    /**
     * Get a random Armour with a given Slot and Quality
     * @param slot to assign to the Armour
     * @param qual to assign to the Armour
     */
    public Armour(final Slot slot, final Quality qual) {
        this(Material.getRandomMaterial(), slot, qual);
    }
    
    /**
     * Get a random Armour with a given Material and Quality
     * @param mat to assign to the Armour
     * @param qual to assign to the Armour
     */
    public Armour(final Material mat, final Quality qual) {
        this(mat, Slot.getRandomSlot(), qual);
    }
    
    /**
     * Get a random Armour with a given Material, Slot and Quality
     * @param mat to assign to the Armour
     * @param slot to assign to the Armour
     * @param qual to assign to the Armour
     */
    public Armour(final Material mat, final Slot slot, final Quality qual) {
        this.mat = mat;
        this.slot = slot;
        this.physicalArmour = this.calculatePhysicalArmor(slot, qual, mat.getPhysicalValue());
        this.magicalArmour = this.calculateMagicalArmor(qual, mat.getMagicalValue());
        super.setQuality(qual);
        super.setDurability(qual, mat.getDurability());
        super.setName(nameMat.get(mat) + nameSlot.get(mat.getWeight()).get(slot));
        super.setMagicAttributes(mat.getMaxMagicSlots(), qual);
    }
    
    /**
     * returns the raw physical armour value
     * @return the raw physical armour value
     */
    public final int getPhysicalArmour() {
        return physicalArmour;
    }
    
    /**
     * returns the total physical armour (base value + magical upgrades)
     * @return the total physical armour (base value + magical upgrades) 
     */
    public final int getTotalPhysicalArmour() {
        int value = physicalArmour;
        final EnumMap<MagicAttribute, Integer> magic = super.getMagicAttributes();
        if (magic.containsKey(MagicAttribute.ARMOUR)) {
            value += magic.get(MagicAttribute.ARMOUR);
        }
        if (magic.containsKey(MagicAttribute.DAMAGEREDUCTION)) {
            value += magic.get(MagicAttribute.DAMAGEREDUCTION);
        }
        return value;
    }
    
    /**
     * returns the raw magical armour value
     * @return the raw magical armour value
     */
    public final int getMagicalArmour() {
        return magicalArmour;
    }
    
    /**
     * returns the total magical armour (base value + magical upgrades)
     * @return the total magical armour (base value + magical upgrades) 
     */
    public final int getTotalMagicalArmour() {
        int value = magicalArmour;
        final EnumMap<MagicAttribute, Integer> magic = super.getMagicAttributes();
        if (magic.containsKey(MagicAttribute.SPELLRESISTANCE)) {
            value += magic.get(MagicAttribute.SPELLRESISTANCE);
        }
        if (magic.containsKey(MagicAttribute.DAMAGEREDUCTION)) {
            value += magic.get(MagicAttribute.DAMAGEREDUCTION);
        }
        return value;        
    }
    
    /**
     * returns the armour's slot
     * @return the armour's slot 
     */
    public final Slot getSlot() {
        return slot;
    }
    
    /**
     * returns the armour's Material
     * @return the armour's Material 
     */
    public final Material getMaterial() {
        return mat;
    }
    
    /*
     * calculates the armour's random raw physical armour value
     * (material base value + quality Bonus) * multiplier defined by slot is the upper bound
     * half that value is the lower round
     */
    private int calculatePhysicalArmor(final Slot slot, final Quality qual, final int armorValue) {
        final int max = (armorValue + physicalBonus.get(qual)) * slot.getMultiplier();
        final int min = max / 2;
        return min + Randomizer.getRandomNumberNIncluded(max - min);
    }
    
    /*
     * calculates the armour's random raw magical armour value
     * Sum of material base magic armour and magic bonus = end value
     */
    private int calculateMagicalArmor(final Quality qual, final int magicArmor) {
        //TODO might want to do more / change stuff
        return magicArmor + magicalBonus.get(qual);
    }
    
    @Override
    public String toString() {
        return "Slot: " + slot + "; Material: " + mat + "; Quality: " + super.getQuality() + "; Armour: " + physicalArmour;
    }

    /**
     * returns the object's weight
     * @return the object's weight 
     */
    @Override
    public final Weight getWeight() {
        return mat.getWeight();
    }
    
    /**
     * If you wish to define every single attribute of the Armour
     * the Builder class is your friend. Make sure you set every 
     * attribute before you call build().
     */
    public static class Builder {
        private int physicalArmour;
        private int magicalArmour;
        private Slot slot;
        private Material mat;
        private String name;
        private boolean translation;
        private boolean unique;
        private Quality qual;
        private int durability;
        private EnumMap<MagicAttribute, Integer> magic;
        
        public Builder physicalArmour(final int physicalArmour){this.physicalArmour = physicalArmour; return this; }
        public Builder magicalArmour(final int magicalArmour){this.magicalArmour = magicalArmour; return this; }
        public Builder slot(final Slot slot){this.slot = slot; return this; }
        public Builder material(final Material mat){this.mat = mat; return this; }
        public Builder quality(final Quality qual){this.qual = qual; return this; }
        public Builder magic(final MagicAttribute magicAttribute, final int value){this.magic.put(magicAttribute, value); return this; }
        public Builder durability(final int durability){this.durability = durability; return this; }
        /**
         * Sets the Armour's name. Can be either a Name on it's own like "Mjölnir" 
         * -> set both booleans to false
         * Or you may use the internationalization files: translation = true. 
         * If the name is unique, unique must be set true.
         * @param name the String to set / lookup
         * @param translation set true if you wish to use the internationalization files
         * @param unique set true if the name to look up is in the UniqueItemNames file, 
         *              false: default Armour file will be used
         * @return the builder object itself.
         */
        public Builder name(final String name, final boolean translation, final boolean unique) {
            this.name = name; 
            this.translation = translation; 
            this.unique = unique;
            return this; 
        }
        
        /**
         * Completes the Builder object to get the Armour object
         * @return Armour with the set attributes
         */
        public Armour build() {
            return new Armour(this);
        }
    }
    
    /**
     * Only called by the Builder.build() process
     * @param builder containing the information for the Armour
     */
    private Armour(final Builder builder) {
        this.physicalArmour = builder.physicalArmour;
        this.magicalArmour = builder.magicalArmour;
        this.slot = builder.slot;
        this.mat = builder.mat;
        super.setBuilderDurability(builder.durability);
        super.setQuality(builder.qual);
        super.setBuilderMagicAttributes(builder.magic);
        if (builder.translation) {
            final ResourceBundle name;
            if (builder.unique) {
                name = ResourceBundle.getBundle("Internationalization.UniqueItemNames", mygame.RPG_1.currentLocale);
            } else {
                name = ResourceBundle.getBundle("Internationalization.Armour", mygame.RPG_1.currentLocale);
            }
            super.setName(name.getString(builder.name));
        } else {
            super.setName(builder.name);
        }
    }
    
}
