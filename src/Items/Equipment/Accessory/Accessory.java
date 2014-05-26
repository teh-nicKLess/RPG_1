package Items.Equipment.Accessory;

import Items.Equipment.Equipment;
import Items.Equipment.MagicAttribute;
import Items.Equipment.Weight;
import Items.Quality;
import java.util.EnumMap;
import java.util.ResourceBundle;


public class Accessory extends Equipment {
    
    private Slot slot;
    private Material mat;
    //Holds part of the name coming from the material
    private static final EnumMap<Material, String> nameMat = new EnumMap<Material, String>(Material.class);
    //Holds part of the name coming from the slot
    private static final EnumMap<Slot, String> nameSlot = new EnumMap<Slot, String>(Slot.class);
    
    static {
        //Fill both enumMaps with the name parts of the currentLocale
        final ResourceBundle names = ResourceBundle.getBundle("Internationalization.Accessory", mygame.RPG_1.currentLocale);
        nameSlot.put(Slot.RING,         names.getString("RING"));
        nameSlot.put(Slot.NECKLACE,     names.getString("NECKLACE"));
        nameSlot.put(Slot.BRACELET,     names.getString("BRACELET"));
        
        nameMat.put(Material.BONE,      names.getString("BONE"));
        nameMat.put(Material.COPPER,    names.getString("COPPER"));
        nameMat.put(Material.SILVER,    names.getString("SILVER"));
        nameMat.put(Material.GOLD,      names.getString("GOLD"));
        nameMat.put(Material.RUBY,      names.getString("RUBY"));
        nameMat.put(Material.SAPPHIRE,  names.getString("SAPPHIRE"));
    }
    
    /**
     * Get a completly random Accessory
     */
    public Accessory() {
        this(Slot.getRandomSlot(), Material.getRandomMaterial(),Quality.getRandomQuality());
    }
    
    /**
     * Get a random Accessory with a given Slot
     * @param slot to assign to the Accessory
     */
    public Accessory(final Slot slot) {
        this(slot, Material.getRandomMaterial(),Quality.getRandomQuality());
    }
    
    /**
     * Get a random Accessory with a given Quality
     * @param qual to assign to the Accessory (can be used in conjuntion 
     *              with Quality.getRandomQuality(maxQuality)
     */
    public Accessory(final Quality qual) {
        this(Slot.getRandomSlot(), Material.getRandomMaterial(), qual);
    }
    
    /**
     * Get a random Accessory with a given Material
     * @param mat to assign to the Accessory
     */
    public Accessory(final Material mat) {
        this(Slot.getRandomSlot(), mat, Quality.getRandomQuality());
    }
    
    /**
     * Get a random Accessory with a given Slot and Material
     * @param slot to assign to the Accessory
     * @param mat to assign to the Accessory
     */
    public Accessory(final Slot slot, final Material mat) {
        this(slot, mat,Quality.getRandomQuality());
    }
    
    /**
     * Get a random Accessory with a given Material and Quality
     * @param mat to assign to the Accessory
     * @param qual to assign to the Accessory
     */
    public Accessory(final Material mat, final Quality qual) {
        this(Slot.getRandomSlot(), mat, qual);
    }
    
    /**
     * Get a random Accessory with a given Slot and Quality
     * @param slot to assign to the Accessory
     * @param qual to assign to the Accessory
     */
    public Accessory(final Slot slot, final Quality qual) {
        this(slot, Material.getRandomMaterial(), qual);
    }
    
    /**
     * Get a random Accessory with a given Slot, Material and Quality
     * If you wish to define every value yourself, please refer to
     * Accessory.Builder
     * @param slot to assign to the Accessory
     * @param mat to assign to the Accessory
     * @param qual to assign to the Accessory 
     */
    public Accessory(final Slot slot, final Material mat, final Quality qual) {
        this.slot = slot;
        this.mat = mat;
        super.setQuality(qual);
        super.setName(nameMat.get(mat) + nameSlot.get(slot));
        super.setDurability(slot.getDurability());
        super.setMagicAttributes(mat.getMaxMagicSlots(), qual);
    }
    
    /**
     * returns the Slot object of the attribute
     * @return the Slot object of the attribute
     */
    public Slot getSlot() {
        return slot;
    }
    
    /**
     * returns the Material object of the attribute
     * @return the Material object of the attribute
     */
    public Material getMaterial() {
        return mat;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("Name: "); sb.append(super.getName()); sb.append("\n");
        sb.append("Quality: "); sb.append(super.getQuality()); sb.append("\n");
        sb.append("C Durability: "); sb.append(super.getDurabilityCurrent()); sb.append("\n");
        sb.append("M Durability: "); sb.append(super.getDurabilityMax()); sb.append("\n");
        sb.append("Magic Attributes: "); sb.append(super.getMagicAttributes()); sb.append("\n");
        sb.append("Slot: "); sb.append(this.getSlot()); sb.append("\n");
        sb.append("Material: "); sb.append(this.getMaterial()); sb.append("\n");
        return sb.toString();
    }
    
    /**
     * returns the object's weight
     * @return the object's weight 
     */
    @Override
    public final Weight getWeight() {
        return slot.getWeight();
    }
    
    /**
     * If you wish to define every single attribute of the Accessory
     * the Builder class is your friend. Make sure you set every 
     * attribute before you call build().
     */
    public static class Builder {
        private Slot slot;
        private Material mat;
        private String name;
        private boolean translation;
        private boolean unique;
        private Quality qual;
        private int durability;
        private EnumMap<MagicAttribute, Integer> magic;
        
        public Builder material(final Material mat){this.mat = mat; return this; }
        public Builder slot(final Slot slot){this.slot = slot; return this; }
        public Builder quality(final Quality qual){this.qual = qual; return this; }
        public Builder magic(final MagicAttribute magicAttribute, final int value){this.magic.put(magicAttribute, value); return this; }
        public Builder durability(final int durability){this.durability = durability; return this; }
        /**
         * Sets the Accessory's name. Can be either a Name on it's own like "Mjölnir" 
         * -> set both booleans to false
         * Or you may use the internationalization files: translation = true. 
         * If the name is unique, unique must be set true.
         * @param name the String to set / lookup
         * @param translation set true if you wish to use the internationalization files
         * @param unique set true if the name to look up is in the UniqueItemNames file, 
         *              false: default Accessory file will be used
         * @return the builder object itself.
         */
        public Builder name(final String name, final boolean translation, final boolean unique) {
            this.name = name; 
            this.translation = translation; 
            this.unique = unique;
            return this; 
        }
        
        /**
         * Completes the Builder object to get the Accessory object
         * @return Accessory with the set attributes
         */
        public Accessory build() {
            return new Accessory(this);
        }
    }
    
    /**
     * Only called by the Builder.build() process
     * @param builder containing the information for the Accessory
     */
    private Accessory(final Builder builder) {
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
                name = ResourceBundle.getBundle("Internationalization.Accessory", mygame.RPG_1.currentLocale);
            }
            super.setName(name.getString(builder.name));
        } else {
            super.setName(builder.name);
        }
    }
    
}
