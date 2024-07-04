import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        int testCase;        
        String eachInput;
        String nTest, nSolution;
        Scanner in = null;
        try {
          in = new Scanner(System.in); 
          testCase = in.nextInt();
          for(int i=0; i < testCase; i++) {
        	eachInput = in.next();
            nTest = "0" + eachInput + "0";
            nSolution = "";      
            for(int j=1; j<(nTest.length()); j++) {
            	String parentheses = "";
            	// check with previous and current number
            	 int prevInt = Integer.parseInt(String.valueOf(nTest.charAt(j-1)));
            	 int curInt = Integer.parseInt(String.valueOf(nTest.charAt(j)));
            	 int checkLeadingPara = prevInt - curInt;
            	 if(checkLeadingPara < 0) {
            		 for(int p = checkLeadingPara; p < 0; p++ ) {
            			 parentheses += "(";
            		 }
            	 } else if (checkLeadingPara > 0) {
		 			for(int p = 0; p < checkLeadingPara; p++ ) {
		 				parentheses += ")";
            		 }
            	 }
            	 if(nTest.length() == (j+1)) {
            		 nSolution += parentheses;
            	 } else {
            		 nSolution += (parentheses + String.valueOf(curInt));
            	 }
            }
            System.out.println("Case #" + (i+1) + ": " + nSolution );
          }
        } catch (Exception e) { 
        } 
        finally { 
            in.close(); 
        } 
    }
}