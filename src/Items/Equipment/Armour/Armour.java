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
    private final static EnumMap<Quality, Integer> physicalBonus = new EnumMap<Quality, Integer>(Quality.class);
    private final static EnumMap<Quality, Integer> magicalBonus = new EnumMap<Quality, Integer>(Quality.class);    
    private final static EnumMap<Material, String> nameMat = new EnumMap<Material, String>(Material.class);
    private final static EnumMap<Weight, EnumMap<Slot, String>> nameSlot = new EnumMap<Weight, EnumMap<Slot, String>>(Weight.class);
    
    static {
        
        physicalBonus.put(Quality.COMMON,       0);
        physicalBonus.put(Quality.UNCOMMON,     5);
        physicalBonus.put(Quality.RARE,         10);
        physicalBonus.put(Quality.EPIC,         20);
        physicalBonus.put(Quality.LEGENDARY,    25);
        physicalBonus.put(Quality.UNIQUE,       physicalBonus.get(Quality.LEGENDARY));
        
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
    
    public Armour() {
        this(Material.getRandomMaterial(), Slot.getRandomSlot(), Quality.getRandomQuality());
    }
    
    public Armour(final Material mat) {
        this(mat, Slot.getRandomSlot(), Quality.getRandomQuality());
    }
    
    public Armour(final Slot slot) {
        this(Material.getRandomMaterial(), slot, Quality.getRandomQuality());
    }
    
    public Armour(final Quality qual) {
        this(Material.getRandomMaterial(), Slot.getRandomSlot(), qual);
    }
    
    public Armour(final Material mat, final Slot slot) {
        this(mat, slot, Quality.getRandomQuality());
    }
    
    public Armour(final Slot slot, final Quality qual) {
        this(Material.getRandomMaterial(), slot, qual);
    }
    
    public Armour(final Material mat, final Quality qual) {
        this(mat, Slot.getRandomSlot(), qual);
    }
    
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
    
    public final int getPhysicalArmour() {
        return physicalArmour;
    }
    
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
    
    public final int getMagicalArmour() {
        return magicalArmour;
    }
    
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
    
    public final Slot getSlot() {
        return slot;
    }
    
    public final Material getMaterial() {
        return mat;
    }
    
    private int calculatePhysicalArmor(final Slot slot, final Quality qual, final int armorValue) {
        final int max = (armorValue + physicalBonus.get(qual)) * slot.getMultiplier();
        final int min = max / 2;
        return min + Randomizer.getRandomNumber(((max - min) + 1));
    }
    
    private int calculateMagicalArmor(final Quality qual, final int magicArmor) {
        //TODO might want to do more / change stuff
        return magicArmor + magicalBonus.get(qual);
    }
    
    @Override
    public String toString() {
        return "Slot: " + slot + "; Material: " + mat + "; Quality: " + super.getQuality() + "; Armour: " + physicalArmour;
    }

    @Override
    public final Weight getWeight() {
        return mat.getWeight();
    }
    
    public static class Builder {
        private int physicalArmour;
        private int magicalArmour;
        private Slot slot;
        private Material mat;
        private String name;
        private boolean translation;
        private Quality qual;
        private int durability;
        private EnumMap<MagicAttribute, Integer> magic;
        
        public Builder physicalArmour(final int physicalArmour){this.physicalArmour = physicalArmour; return this; }
        public Builder magicalArmour(final int magicalArmour){this.magicalArmour = magicalArmour; return this; }
        public Builder slot(final Slot slot){this.slot = slot; return this; }
        public Builder material(final Material mat){this.mat = mat; return this; }
        public Builder name(final String name, final boolean translation){this.name = name; this.translation = translation; return this; }
        public Builder quality(final Quality qual){this.qual = qual; return this; }
        public Builder magic(final MagicAttribute magicAttribute, final int value){this.magic.put(magicAttribute, value); return this; }
        public Builder durability(final int durability){this.durability = durability; return this; }
        
        public Armour build() {
            return new Armour(this);
        }
    }
    
    private Armour(final Builder builder) {
        this.physicalArmour = builder.physicalArmour;
        this.magicalArmour = builder.magicalArmour;
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
