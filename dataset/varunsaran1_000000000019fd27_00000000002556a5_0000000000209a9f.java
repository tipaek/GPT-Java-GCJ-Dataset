import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = Integer.parseInt(in.nextLine()) ; // Number of Test Cases
        int caseNumber = 1 ;
        while (caseNumber <= num) {
            
            String number = in.nextLine() ;
            StringBuilder parenthesisString = new StringBuilder() ;
            int leftParanthesisCounter = 0 ;
            
            for (char temp :number.toCharArray()) {
                int digit = Character.getNumericValue(temp) ;
                while (leftParanthesisCounter < digit ) {
                    parenthesisString.append("(") ;
                    leftParanthesisCounter++ ;
                }
                while (leftParanthesisCounter > digit ) {
                    parenthesisString.append(")") ;
                    leftParanthesisCounter-- ;
                }
                parenthesisString.append(temp) ;
            }
           
            while (leftParanthesisCounter > 0 ) {
                parenthesisString.append(")") ;
                leftParanthesisCounter-- ;
            }
            
            System.out.println("Case #" + caseNumber + ": " + parenthesisString.toString());
            caseNumber++ ;
        }

    }

}
