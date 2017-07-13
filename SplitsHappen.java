/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitshappen;

/**
 *
 * @author peter
 */
public class SplitsHappen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CCalculate  cCalculate=new CCalculate();
        
        // Calculate score
        int score=cCalculate.calculateScore(args[0]);
        
        // Output score
        System.out.println("Score="+score);
    }
        
}
