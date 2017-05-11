package id3breastcancer;

/**
 * Auxiliary class with functions
 * @author PC
 */
public class Functions {
    
    public static final double LOG2 = Math.log(2);
    
    /*
    * Gets the log or 
    */
    public static double getLog2(int x, int total) {
        double ratio = ((double) x / (double) total);
        double log = Math.log(ratio) / LOG2;
        double resp = -1 * log * (ratio);
        return resp;
    }
    
}
