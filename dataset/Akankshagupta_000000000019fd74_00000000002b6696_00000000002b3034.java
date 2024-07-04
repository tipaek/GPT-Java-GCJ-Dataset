import java.util.Scanner;
import java.util.HashMap;
import java.lang.StringBuilder;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt( in .nextLine());
        String input = null;
         StringBuilder output = new StringBuilder("*");

        for (int noOfCases = 0; noOfCases < cases; noOfCases++) {
            StringBuilder startPattern = null;
            StringBuilder endPattern = null;
            output = null;
            int patterns = Integer.parseInt( in.nextLine());
             for (int noOfPatterns = 0; noOfPatterns < patterns; noOfPatterns++){
                input = String.valueOf(in .nextLine());
                if(output== null || !output.toString().equals("*"))
                if(input.startsWith("*")){
                    String subString = input.substring(1, input.length());
                 
                    if(endPattern == null){
                      endPattern= new StringBuilder(subString);
                      
                      output = endPattern;
                    }
                    else if( subString.length() > endPattern.length()){
                        int diff = subString.length()- endPattern.length();
                         if(subString.substring(diff, subString.length()).equals(endPattern.toString())){
                       
                            endPattern = new StringBuilder(subString);
                            output = endPattern;
                         }
                          else output = new StringBuilder("*");
                    }
                    else if( subString.length() < endPattern.length()){
                        int diff =  endPattern.length()- subString.length();
                         if(endPattern.toString().endsWith(subString)){
                             
                         }
                          else output = new StringBuilder("*");
                    }
                    else if(!subString.equals(endPattern.toString()) )
                    output = new StringBuilder("*");
                }
                
                if(input.endsWith("*")){}
             
             }
            
            System.out.println("Case " + "#"+(noOfCases+1)+": " + output);

        }
        

    }
}