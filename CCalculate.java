package splitshappen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peter
 */
public class CCalculate {
    final int STRIKE=10;
    final int SPARE=11;
    final int MISS=0;

    public int calculateScore(String sequence){
        int score=0;
        int sequenceLength=sequence.length();
        
        // Make integer array
        int[] integerArray=new int[sequenceLength];
        for (int i=0; i<sequenceLength; ++i){
            switch(sequence.charAt(i)){
                case 'X':
                case 'x': integerArray[i]=STRIKE;
                    break;
                case '/': integerArray[i]=SPARE;
                    break;
                case '-': integerArray[i]=MISS;
                    break;
                default: integerArray[i]=Character.getNumericValue(sequence.charAt(i));
            }
        }
        
        // Account for strike or spare in last frame
        if (integerArray[sequenceLength-3]==STRIKE){
            int end=sequenceLength-3;
            int previousStrikeCount=0;
            for (int i=0; i<end; ++i) if (integerArray[i]==STRIKE) ++previousStrikeCount;
            int frame=(int)((end+previousStrikeCount)/2)+1;
            if (frame==10) sequenceLength-=2;
        }
        else if (integerArray[sequenceLength-2]==SPARE) sequenceLength-=1;
        
        // Determine score from integer array
        for (int i=0; i<sequenceLength; ++i){
            if (integerArray[i]==SPARE){
                score+=10+integerArray[i+1]-integerArray[i-1];
            } 
            else score+=integerArray[i];
            if (integerArray[i]==STRIKE){
                score+=(integerArray[i+2]==SPARE)? 10 :
                        integerArray[i+1]+integerArray[i+2];
            }
        }
        
        return score;
    }
}
