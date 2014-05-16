package Utilities;

import java.util.Random;


public abstract class Randomizer {
    
    private final static Random rnd = new Random();
    
    
    public static int getRandomNumber(final int n) {
        return n <= 0 ?  0 : rnd.nextInt(n);
    }
    
    public static int getRandomNumber() {
        return rnd.nextInt();
    }
    
    public static double getNextGaussian() {
        return rnd.nextGaussian();
    }
    
}
