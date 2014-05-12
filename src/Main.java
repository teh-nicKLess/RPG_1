
public class Main {

	public static void main(String[] args) {
		double max = 0, avg = 0, min = Double.MAX_VALUE;
		int iterations = 50000;
		
		for (int i = 0; i < iterations; i++) {
			Armour myArmour = new Armour(Material.STEEL, BodyPart.CHEST);
//			Armour myArmour = new Armour();
//			System.out.println(myArmour.toString());
			
			//TODO: min, max, avg ausrechnen und überprüfen
			double value = myArmour.getValue();
			if (value > max) max = min = value;
			else if (value < min) min = value;
			avg += value;
		}
		avg /= iterations;
		System.out.printf("Min: %.2f Max: %.2f Avg: %.2f", min, max, avg);
		
	}

}
