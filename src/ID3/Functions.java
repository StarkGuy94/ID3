package ID3;

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
        if(x<=0){
            return 0;
        }
        double ratio = ((double) x / (double) total);
        double log = Math.log(ratio) / LOG2;
        double resp = -1 * log * (ratio);
        return resp;
    }
    
    public static int ageInterval(int x){
        if(x<=42){
            return 1;
        }else if(x<=65){
            return 2;
        }else{
            return 3;
        }
    }
    
}
