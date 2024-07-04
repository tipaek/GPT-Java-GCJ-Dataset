
import java.util.*;

import java.io.*;
public class Solution {
    public static String guessString1;
    public static String guessString2;
    public static int askAnotherPos;
    static String complement(String str){
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                str = str.substring(0, i) 
                + '1' 
                + str.substring(i + 1); 
            }
            else{
                str = str.substring(0, i) 
                + '0' 
                + str.substring(i + 1); 
            }
        }
        return str;
    }
    static String reversal(String str){
        int start = str.length() -1;
         int end =0;
         StringBuilder string = new StringBuilder(str); 
        for(; start >=0 && end<str.length() ; --start, ++end) {
            char temp = str.charAt(end) ;
            string.setCharAt(end, str.charAt(start));
            string.setCharAt(start, temp);
        
    }
    return string.toString();
}
    static String compReversal(String str){
       String res = complement(str);
       String finalRes = reversal(res);
        return finalRes;
        
    }
    static int findUniqueStringPos(String compReversalVal, String reversalVal, String complementVal){
            for(int i =0; i<compReversalVal.length(); i++){
                if((compReversalVal.charAt(i) != reversalVal.charAt(i)) || (reversalVal.charAt(i) != complementVal.charAt(i)) || (complementVal.charAt(i) != compReversalVal.charAt(i)) ){
                    return i;
                }
            }
            return 0;
    }
    static int findDiffPosition(String guess1, String guess2){
        for(int i =0; i<guess1.length(); i++){
            if(guess1.charAt(i) != guess2.charAt(i)){
                return i;
            }
        }
        return 0;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
        int b = in.nextInt();
        String judgeInput = in.next();
        String reversalVal,complementVal, compReversalVal;
        Boolean isReversalVal = false;
        Boolean isCompRevVal = false;
        Boolean isCompVal = false;
        if(i % 10 == 1){
            compReversalVal = compReversal(judgeInput);
            reversalVal = reversal(judgeInput);
            complementVal = complement(judgeInput);
            int askPos = findUniqueStringPos(compReversalVal, reversalVal, complementVal);
            System.out.println(askPos);
            int readChar = in.nextInt();
            if(readChar == Character.getNumericValue(compReversalVal.charAt(askPos))){
                isCompRevVal = true;
            }
            if(readChar == Character.getNumericValue(reversalVal.charAt(askPos))){
                isReversalVal = true;
            }
            if(readChar == Character.getNumericValue(complementVal.charAt(askPos))){
                isCompVal = true;
            }
            if(isCompRevVal && isReversalVal){
                guessString1 = compReversalVal;
                guessString2 = reversalVal;
                askAnotherPos =findDiffPosition(guessString1, guessString2);
                System.out.println(askAnotherPos);
                int readChar1 = in.nextInt();
                if(readChar1 == Character.getNumericValue(guessString1.charAt(askAnotherPos))){
                    System.out.println(guessString1);
                }
                else if(readChar1 == Character.getNumericValue(guessString2.charAt(askAnotherPos))){
                    System.out.println(guessString2);
                }
                String result = in.next();
                if(result.equalsIgnoreCase("N"))
                    break;
                 else
                    continue;
                
            }
            else if(isReversalVal && isCompVal ){
                guessString1 = reversalVal;
                guessString2 = complementVal;
                askAnotherPos =findDiffPosition(guessString1, guessString2);
                System.out.println(askAnotherPos);
                int readChar1 = in.nextInt();
                if(readChar1 == Character.getNumericValue(guessString1.charAt(askAnotherPos))){
                    System.out.println(guessString1);
                }
                else if(readChar1 == Character.getNumericValue(guessString2.charAt(askAnotherPos))){
                    System.out.println(guessString2);
                }
                String result = in.next();
                if(result.equalsIgnoreCase("N"))
                    break;
                else
                    continue;
            }
            else if(isCompVal && isCompRevVal){
                guessString1 = complementVal;
                guessString2 = compReversalVal;
                askAnotherPos =findDiffPosition(guessString1, guessString2);
                System.out.println(askAnotherPos);
                int readChar1 = in.nextInt();
                if(readChar1 == Character.getNumericValue(guessString1.charAt(askAnotherPos))){
                    System.out.println(guessString1);
                }
                else if(readChar1 == Character.getNumericValue(guessString2.charAt(askAnotherPos))){
                    System.out.println(guessString2);
                }
                String result = in.next();
                if(result.equalsIgnoreCase("N"))
                    break;
                else
                    continue;

            }
            else if(isCompRevVal){
                System.out.println(compReversalVal);
                String result = in.next();
                if(result.equalsIgnoreCase("N"))
                    break;
                 else
                    continue;
            }
            else if(isReversalVal){
                System.out.println(reversalVal);
                String result = in.next();
                if(result.equalsIgnoreCase("N"))
                    break;
                 else
                    continue;
            }
            else if(isCompVal){
                System.out.println(complementVal);
                String result = in.next();
                if(result.equalsIgnoreCase("N"))
                    break;
                else
                    continue;
            }

        }
        else{
            System.out.println(askAnotherPos);
            int readChar = in.nextInt();
            System.out.println(judgeInput);
        String result = in.next();
        if(result.equalsIgnoreCase("N"))
            break;
         else
            continue;

        }
    }
        
	}
}