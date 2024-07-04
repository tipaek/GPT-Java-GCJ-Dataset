
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        
        Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        
        for(int testIndex = 0 ;testIndex < testCount ; testIndex++){
            String  input = in.nextLine();
           // System.out.println(input);
            String output = getOutput(input);
            System.out.println("Case #"+(testIndex+1)+": "+output);
        }
    }
    
    private static String getOutput(String input){
        StringBuffer outputString = new StringBuffer("");
        int lastBrackets = 0;
        int lastNumber = 0;
        
        for(int i = 0; i<input.length() ;i++ ){
            int currentInt = Integer.valueOf(input.substring(i, i+1));
            if(lastNumber < currentInt){
                for(int j = lastNumber ; j< currentInt ;j ++){
                    outputString.append("(");
                    lastBrackets ++;
                }
            }
            if(lastNumber > currentInt){
                for(int j = currentInt ; j< lastNumber ;j ++){
                    outputString.append(")");
                    lastBrackets --;
                }
            }
            outputString.append(currentInt);
            lastNumber = currentInt;
        }
        for(int i = 0 ;i < lastBrackets ;i++){
            outputString.append(")");
        }
        return outputString.toString();
    }
}
