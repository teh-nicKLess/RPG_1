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
    private static final EnumMap<Material, String> nameMat = new EnumMap<Material, String>(Material.class);
    private static final EnumMap<Slot, String> nameSlot = new EnumMap<Slot, String>(Slot.class);
    
    static {
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
    
    public Accessory() {
        this(Slot.getRandomSlot(), Material.getRandomSlot(),Quality.getRandomQuality());
    }
    
    public Accessory(final Slot slot) {
        this(slot, Material.getRandomSlot(),Quality.getRandomQuality());
    }
    
    public Accessory(final Quality qual) {
        this(Slot.getRandomSlot(), Material.getRandomSlot(), qual);
    }
    
    public Accessory(final Material mat) {
        this(Slot.getRandomSlot(), mat, Quality.getRandomQuality());
    }
    
    public Accessory(final Slot slot, final Material mat) {
        this(slot, mat,Quality.getRandomQuality());
    }
    
    public Accessory(final Material mat, final Quality qual) {
        this(Slot.getRandomSlot(), mat, qual);
    }
    
    public Accessory(final Slot slot, final Quality qual) {
        this(slot, Material.getRandomSlot(), qual);
    }
    
    public Accessory(final Slot slot, final Material mat, final Quality qual) {
        this.slot = slot;
        this.mat = mat;
        super.setQuality(qual);
        super.setName(nameMat.get(mat) + nameSlot.get(slot));
        super.setDurability(qual, slot.getDurability());
        super.setMagicAttributes(mat.getMaxMagicSlots(), qual);
    }
    
    public Slot getSlot() {
        return slot;
    }
    
    public Material getMaterial() {
        return mat;
    }
    
    @Override
    public final Weight getWeight() {
        return slot.getWeight();
    }
    
    public static class Builder {
        private Slot slot;
        private Material mat;
        private String name;
        private boolean translation;
        private Quality qual;
        private int durability;
        private EnumMap<MagicAttribute, Integer> magic;
        
        public Builder material(final Material mat){this.mat = mat; return this; }
        public Builder slot(final Slot slot){this.slot = slot; return this; }
        public Builder name(final String name, final boolean translation){this.name = name; this.translation = translation; return this; }
        public Builder quality(final Quality qual){this.qual = qual; return this; }
        public Builder magic(final MagicAttribute magicAttribute, final int value){this.magic.put(magicAttribute, value); return this; }
        public Builder durability(final int durability){this.durability = durability; return this; }
        
        public Accessory build() {
            return new Accessory(this);
        }
    }
    
    private Accessory(final Builder builder) {
        this.slot = builder.slot;
        this.mat = builder.mat;
        super.setBuilderDurability(builder.durability);
        super.setQuality(builder.qual);
        super.setBuilderMagicAttributes(builder.magic);
        if (builder.translation) {
            final ResourceBundle name = ResourceBundle.getBundle("Internationalization.UniqueItemNames", mygame.RPG_1.currentLocale);
            super.setName(name.getString(builder.name));
        } else {
            super.setName(builder.name);
        }
    }
    
}
