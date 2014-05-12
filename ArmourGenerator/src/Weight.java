/**
 * 
 * @author Matthias
 *
 */
public enum Weight {
	HEAVY (0),
	MEDIUM (1),
	LIGHT (2);
	
	// used with BodyPart.index to create a key,
	// which is used in HashMap to choose armour name
	// can be 255 at max
	private final int index;
	
	Weight (int index) {
		this.index = index;
	}
	
	int index() { return index; }
}
