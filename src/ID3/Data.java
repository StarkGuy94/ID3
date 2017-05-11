package ID3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Retrieves, stores and manages data form the set
 *
 * @author PC
 */
public class Data {
    private final static String[] HEADERS = {"BIRADS","Age","Shape","Margin","Density","Severity"};
    private ArrayList<Node> dataset;
    private final int severity;
    private Set<Integer>[] type;
    private Set<Integer> colRestricted;
    public Data() {
        dataset = new ArrayList<>();
        colRestricted = new HashSet<>();
        severity = 5;
        type = new HashSet[5];
        for(int i=0;i<5;i++){
            type[i]= new HashSet<>();
        }
    }
    public void reader() {
        CharSequence cs = "?";
        try {
            Scanner scan = new Scanner(new File("Resources/data.txt"));
            int[] intVal;
            while (scan.hasNextLine()) {
                intVal = new int[6];
                String line = scan.nextLine();
                if (!line.contains(cs)) {
                    String[] att = line.split(",");
                    for(int i=0;i<5;i++){
                        if(i==1){
                            intVal[i] = Functions.ageInterval(Integer.parseInt(att[i]));
                        }else{
                            intVal[i]= Integer.parseInt(att[i]);
                        }
                        type[i].add(intVal[i]);
                    }
                    intVal[5]= Integer.parseInt(att[5]);
                    dataset.add(new Node(intVal));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void printer() {
        for (Node node : dataset) {
            System.out.println(node.toString());
        }
    }
    public int getMinEnthropyColumn(List<Node> dataSet){
        double enthropy =Integer.MAX_VALUE;
        int column = 0;
        for(int i=0;i<5;i++){
            if(!colRestricted.contains(i) && enthropy<getEnthropy(dataSet,i)){
                column=i;
            }
        }
        return column;
    }
    public int getMinEnthropyColumn(){
        double enthropy =Integer.MAX_VALUE;
        int column = 0;
        for(int i=0;i<5;i++){
            if(!colRestricted.contains(i) && enthropy<getEnthropy(this.dataset,i)){
                column=i;
            }
        }
        return column;
    }
    public double debugEn(){
        return getEnthropy(this.dataset,getMinEnthropyColumn(this.dataset));
    }
    public double getEnthropy(List<Node> dataSet, int column) {
       int total = countTotal(dataSet);
       double enthropy = 0;
       for(int i=0;i<type[column].size();i++){
           List<Node> setCat = getSetType(dataSet,column,i+1);
           int totalByCat = countTotal(setCat);
           int countPositive = countPositive(setCat);
           double ratio = (double)totalByCat/(double)total;
           int countNegative = totalByCat - countPositive;
           double catEnthropy= (ratio)*(Functions.getLog2(countPositive, totalByCat)+Functions.getLog2(countNegative, totalByCat));
           //System.out.println("Tipo "+i+" ,Ratio:"+ratio+" Total:"+totalByCat+" Positivos: "+countPositive+", Negativos:"+countNegative+", Entropia Total:"+catEnthropy+"Entropia Positiva:"+Functions.getLog2(countPositive, totalByCat)+", Entropia Negativa:"+Functions.getLog2(countNegative, totalByCat));
           enthropy+=catEnthropy;
       }
       return enthropy;
    }
    public List<Node> getSetType(List<Node> dataSet, int column, int type){
        List<Node> newSet = new ArrayList<>();
        for(Node tuple:dataSet){
            if(tuple.getValue(column)==type){
                newSet.add(tuple);
            }
        }
        return newSet;
    }
    public int countTotal(List<Node> dataSet){
        return dataSet.size();
    }
    public int countByType(List<Node> dataSet, int column, int type){
        int count = 0;
        for(Node tuple:dataSet){
            if(tuple.getValue(column)==type){
                count++;
            }
        }
        return count;
    }
    public int countPositive(List<Node> dataSet){
        int count =0;
        for(Node tuple:dataSet){
            if(tuple.getValue(severity)==1){
                count++;
            }
        }
        return count;
    }
    public void printCat(){
        for(int i=0;i<type.length;i++){
            System.out.println(HEADERS[i]+":\t--");
            Iterator<Integer> it = type[i].iterator();
            while(it.hasNext()){
                System.out.println("\t-"+it.next());
            }
        }
    }
    public boolean canExpand(){
        if(countTotal(this.dataset)==0){
            return false;
        }
        if(this.getEnthropy(this.dataset, this.getMinEnthropyColumn(this.dataset))==-1){
            return false;
        }
        if(this.dataset.isEmpty()){
            return false;
        }
        return this.colRestricted.size() < 5;
    }
    public Set<Integer> getTypes(int column){
        return type[column];
    }
}
