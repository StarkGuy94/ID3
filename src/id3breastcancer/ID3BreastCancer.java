/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id3breastcancer;

/**
 *
 * @author PC
 */
public class ID3BreastCancer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Data dataset = new Data();
        dataset.reader();
        dataset.printer();
    }
    
}
