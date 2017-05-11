package id3breastcancer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Retrieves, stores and manages data form the set
 *
 * @author PC
 */
public class Data {

    private ArrayList<Node> dataset;
    private ArrayList<Double> enthropies;

    public Data() {
        dataset = new ArrayList<>();
    }

    /*
     * Reads the data set and stores each line in a node of the array
     */
    public void reader() {
        CharSequence cs = "?";
        try {
            Scanner scan = new Scanner(new File("Resources/data.txt"));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (!line.contains(cs)) {
                    System.out.println(line);
                    String[] att = line.split(",");
                    dataset.add(new Node(Integer.parseInt(att[0]),
                            Integer.parseInt(att[1]), Integer.parseInt(att[2]),
                            Integer.parseInt(att[3]), Integer.parseInt(att[4]),
                            Integer.parseInt(att[5])));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * Auxiliary method for verifyng that data has been loaded
     */
    public void printer() {
        for (Node node : dataset) {
            System.out.println(node.toString());
        }
    }
    
    public void enthropies() {
        for (int i = 0; i < 5; i++) {
            
        }
    }

    public double H(Integer attribute) {
        return 0;
    }

    private double PJ(Integer attribute) {
        return 0;
    }
    
    private double PCJ(Integer attribute) {
        return 0;
    }

}
