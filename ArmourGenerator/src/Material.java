/**
 * 
 * @author Matthias
 *
 */
public enum Material {
	IRON (10.0, "Eisen", Weight.HEAVY),
	STEEL (14.0, "Stahl", Weight.HEAVY),
	LEATHER (5.0, "Leder", Weight.MEDIUM),
	CHAIN (8.0, "Ketten", Weight.MEDIUM),
	WOOL (2.0, "Woll", Weight.LIGHT),
	SILK (3.0, "Seiden", Weight.LIGHT);
	
	private final double baseValue;
	private final String label;
	private final Weight weight;
	
	
	private Material(double baseValue, String label, Weight weight) {
		this.baseValue = baseValue;
		this.label = label;
		this.weight = weight;
	}
	
	double baseValue() { return baseValue; }
	String label() { return label; }
	Weight weight() { return weight; }
	
}
