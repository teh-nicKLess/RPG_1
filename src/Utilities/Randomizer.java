package Utilities;

import java.util.Random;


public abstract class Randomizer {
    
    //Holds the Random object
    private final static Random rnd = new Random();
    
    
    /**
     * returns an Integer [0, n]
     * @param n upper bound
     * @return random Integer [0, n]
     */
    public static int getRandomNumberNIncluded(final int n) {
        return getRandomNumber(n + 1);
    }
    
    /**
     * returns an Integer [0, n)
     * @param n upper bound
     * @return random Integer [0, n)
     */
    public static int getRandomNumber(final int n) {
        return n <= 0 ?  0 : rnd.nextInt(n);
    }
    
    /**
     * returns a random int
     * @return a random int
     */
    public static int getRandomNumber() {
        return rnd.nextInt();
    }
    
    /**
     * returns a random double [-1, 1]
     * @return a random double [-1, 1]
     */
    public static double getNextGaussian() {
        return rnd.nextGaussian();
    }
    
}
