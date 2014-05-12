/**
 * 
 * @author Matthias
 *
 */
public enum BodyPart {
	
	CHEST (6.0),
	LEGS (4.0),
	FEET (1.0),
	HANDS (2.0),
	HEAD (3.0);
	
	private final double multiplier;
	
	private BodyPart(double multiplier) {
		this.multiplier = multiplier;
	}
	
	double multiplier() { return multiplier; }
}
