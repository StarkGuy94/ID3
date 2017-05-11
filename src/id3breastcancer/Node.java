package id3breastcancer;

/** This class acts as one line of the data set and stores its values
 *
 * @author PC
 */
public class Node {
    
    private final int birats;
    private final int age;
    private final int shape;
    private final int margin;
    private final int density;
    private final int severity;

    /*
    * Gets the arguments from the entries in the data set
    */
    public Node(int BIRADS, int age, int shape, int margin, int density, int severity) {
        this.birats = BIRADS;
        this.age = age;
        this.shape = shape;
        this.margin = margin;
        this.density = density;
        this.severity = severity;
    }

    public int getBIRADS() {
        return birats;
    }

    public int getAge() {
        return age;
    }

    public int getShape() {
        return shape;
    }

    public int getMargin() {
        return margin;
    }

    public int getDensity() {
        return density;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "Node:" + "BIRADS=" + birats + "\tage=" + age + "\tshape=" + shape + "\tmargin=" + margin + "\tdensity=" + density + "\tseverity=" + severity;
    }
    
    
    
    
}
