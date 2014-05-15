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
    private final static EnumMap<Material, String> nameMat = new EnumMap<Material, String>(Material.class);
    private final static EnumMap<Weight, EnumMap<Slot, String>> nameSlot = new EnumMap<Weight, EnumMap<Slot, String>>(Weight.class);
    
    static {
        ResourceBundle names = ResourceBundle.getBundle("Internationalization.Armour", mygame.RPG_1.currentLocale);
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
    
    public Armour(Material mat) {
        this(mat, Slot.getRandomSlot(), Quality.getRandomQuality());
    }
    
    public Armour(Slot slot) {
        this(Material.getRandomMaterial(), slot, Quality.getRandomQuality());
    }
    
    public Armour(Quality qual) {
        this(Material.getRandomMaterial(), Slot.getRandomSlot(), qual);
    }
    
    public Armour(Material mat, Slot slot) {
        this(mat, slot, Quality.getRandomQuality());
    }
    
    public Armour(Slot slot, Quality qual) {
        this(Material.getRandomMaterial(), slot, qual);
    }
    
    public Armour(Material mat, Quality qual) {
        this(mat, Slot.getRandomSlot(), qual);
    }
    
    public Armour(Material mat, Slot slot, Quality qual) {
        this.mat = mat;
        this.slot = slot;
        this.physicalArmour = this.calculatePhysicalArmor(slot, qual, mat.getBaseValue());
        this.magicalArmour = this.calculateMagicalArmor(qual);
        super.setQuality(qual);
        super.setDurability(qual, mat.getDurability());
        super.setName(nameMat.get(mat) + nameSlot.get(mat.getWeight()).get(slot));
        super.setMagicAttributes(mat.getMaxMagicSlots(), qual);
    }
    
    public final int getPhysicalArmour() {
        int value = magicalArmour;
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
    
    private int calculatePhysicalArmor(Slot slot, Quality qual, int armorValue) {
        int max = armorValue * slot.getMultiplier();
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: max += 25; break;
            case EPIC:      max += 20; break;
            case RARE:      max += 15; break; 
            case UNCOMMON:  max += 5;  break;
            case COMMON:    max += 0;  break;
            default:        assert false; max = 0;
        }
        final int min = max / 2;
        return min + Randomizer.getRandomNumber(((max - min) + 1));
    }
    
    private int calculateMagicalArmor(Quality qual) {
        final int value;
        switch (qual) {
            case UNIQUE:
            case LEGENDARY: value = 25; break;
            case EPIC:      value = 20; break;
            case RARE:      value = 15; break; 
            case UNCOMMON:  value = 5;  break;
            case COMMON:    value = 0;  break;
            default:        assert false; value = 0;
        }
        return value;
    }
    
    @Override
    public String toString() {
        return "Slot: " + slot + "; Material: " + mat + "; Quality: " + super.getQuality() + "; Armour: " + physicalArmour;
    }

    @Override
    public final Weight getWeight() {
        return mat.getWeight();
    }
    
}
