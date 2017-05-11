package ID3;

import java.util.HashSet;
import java.util.Set;

/** This class acts as one line of the data set and stores its values
 *
 * @author PC
 */
public class Node {
    private final int[] data;
    /*
    * Gets the arguments from the entries in the data set
    */
    public Node(int[] data) {
        this.data = data;
    }
    public int getValue(int column){
        return data[column];
    }
    public String toString(){
        StringBuilder retVal = new StringBuilder();
       retVal.append("BIRADS:").append(data[0]).append("\t");
       retVal.append("Age Group:").append(data[1]).append("\t");
       retVal.append("Shape:").append(data[2]).append("\t");
       retVal.append("Margin:").append(data[3]).append("\t");
       retVal.append("Density:").append(data[4]).append("\t");
       retVal.append("Severity:").append(data[5]).append("\t");
        return retVal.toString();
    }
}
