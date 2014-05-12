/**
 * 
 * @author Matthias
 *
 */
public enum BodyPart {
	
	CHEST (0, 6.0),
	LEGS (1, 4.0),
	FEET (2, 1.0),
	HANDS (3, 2.0),
	HEAD (4, 3.0);
	
	private final double multiplier;
	
	// used with Weight.index to create a key,
	// which is used in HashMap to choose armour name
	// should be 255 at max
	private final int index;
	
	BodyPart(int index, double multiplier) {
		this.index = index;
		this.multiplier = multiplier;
	}
	
	double multiplier() { return multiplier; }
	int index() { return index * 256; }
}
