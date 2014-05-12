import java.util.HashMap;
import java.util.Random;

/**
 * 
 * @author Matthias
 *
 */
public class Armour {
	private final static HashMap<String, String> nameMap = new HashMap<>();
	
	
	private final Material material;
	private final BodyPart bodyPart;
	private double armourValue;
	private String name;
	
	
	public Armour() {
				
		this.material = rollMaterial();
		this.bodyPart = rollBodyPart();
		
		initArmour();
	}

	public Armour(Material material) {
		
		this.material = material;
		this.bodyPart = rollBodyPart();
		
		initArmour();
	}
	
	public Armour(BodyPart bodyPart) {
		
		this.material = rollMaterial();
		this.bodyPart = bodyPart;
		
		initArmour();
	}
	
public Armour(Material material, BodyPart bodyPart) {
		
		this.material = material;
		this.bodyPart = bodyPart;
		
		initArmour();
	}
	
	private void initArmour() {
		if (nameMap.isEmpty()) {
			initNameMap();
		}
		
		this.armourValue = rollArmourValue();
		
		// Get armour name depending on weight, material and body part
		String namePart = nameMap.get(material.weight().name() + "_" + bodyPart.name());
		this.name = material.label() + namePart;
	}
	
	private void initNameMap() {
		nameMap.put( "HEAVY_CHEST", "brustpanzer" );
		nameMap.put( "HEAVY_LEGS", "beinschienen" );
		nameMap.put( "HEAVY_FEET", "schuhe" );
		nameMap.put( "HEAVY_HANDS", "handschuhe" );
		nameMap.put( "HEAVY_HEAD", "helm" );
		
		nameMap.put( "MEDIUM_CHEST", "weste" );
		nameMap.put( "MEDIUM_LEGS", "hose" );
		nameMap.put( "MEDIUM_FEET", "stiefel" );
		nameMap.put( "MEDIUM_HANDS", "handschuhe" );
		nameMap.put( "MEDIUM_HEAD", "kappe" );
		
		nameMap.put( "LIGHT_CHEST", "hemd" );
		nameMap.put( "LIGHT_LEGS", "rock" );
		nameMap.put( "LIGHT_FEET", "mokassins" );
		nameMap.put( "LIGHT_HANDS", "handschuhe" );
		nameMap.put( "LIGHT_HEAD", "kapuze" );
		
	}
	
	private Material rollMaterial() {
		// Choose random material
		int size = Material.values().length;
		int choice = new Random().nextInt(size);
		return Material.values()[choice];
	}
	
	private BodyPart rollBodyPart() {
		// Choose random body part
		int size = BodyPart.values().length;
		int choice = new Random().nextInt(size);
		return BodyPart.values()[choice];
	}

	private double rollArmourValue() {
		double value = material.baseValue() * bodyPart.multiplier();
		
		// is in most cases between -0.2*value and 0.2*value
		double randomComp = new Random().nextGaussian() * 0.2 * value;
		
		return value + randomComp;
	}

	public String getName() {
		return name;
	}
	
	public double getValue() {
		return armourValue;
	}

	
	public String toString() {
		String formattedValue = String.format(": %.2f", armourValue);
		return name + formattedValue;
	}
}
