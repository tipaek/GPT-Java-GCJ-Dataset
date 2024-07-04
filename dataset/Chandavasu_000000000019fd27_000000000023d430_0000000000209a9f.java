import java.lang.*;
import java.util.*;
public class Solution{

     public static void main(String []args){
        Scanner in = new Scanner(System.in);
        
        int noOfTest = Integer.parseInt(in.nextLine());
        
        for(int n = 0; n < noOfTest; n++) {
            String input = in.nextLine();
            
            StringBuilder output = new StringBuilder();
           // System.out.println("Input : " + input);
            
            char[] inpChars = input.toCharArray();
            int prevVal = 0;
            int closeBraces = 0;
            
            for(int i = 0; i < inpChars.length; i++) {
                
                int val = Integer.parseInt(inpChars[i] + "");
                //System.out.print("val : " + val);
                
                if(val < prevVal) {
                    
                    for(int j = 0; j < (prevVal - val); j++) {
                        
                        output.append(")");
                        closeBraces--;
                    }
                    
                } else if(val == prevVal) {
                
                    //Do nothing
                } else {
                
                    for(int j = prevVal; j < val; j++) {
                        
                        output.append("(");
                        closeBraces++;
                    }
                }
                output.append(val);
                
                prevVal = val;
            }
            
            for(int i = 0; i < closeBraces; i++) {
                
                output.append(")");
            }
            
            System.out.println("Case #" + (n+1) + ": " + output.toString());
        }
     }
}