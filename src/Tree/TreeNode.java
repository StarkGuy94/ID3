/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import ID3.Data;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author alxalmora
 */
public class TreeNode {
    private int id;
    private int column;
    private Data data;
    private ArrayList<TreeNode> childrens;
    private static int idCounter=0;
    private int type;
    private int fatherColumn;
    public TreeNode(int column, Data data, int type, int fatherColumn){
        this.data = data;
        this.type = type;
        this.fatherColumn = fatherColumn;
        this.column = column;
        id = idCounter++;
        childrens = new ArrayList<>();
    }
    public void addChildren(TreeNode children){
        childrens.add(children);
    }
    public boolean hasChildren(){
        return childrens.isEmpty();
    }
    
    public boolean isFinalNode(){
        return !this.data.canExpand();
    }
    private void expandTree(){
        if(!isFinalNode()){
            int bestColumn = data.getMinEnthropyColumn();
            Set<Integer> categories = data.getTypes(bestColumn);
            for(int cat: categories){
                //this.childrens(new TreeNode(bestColumn,data.get))
            }
        }
    }
}
