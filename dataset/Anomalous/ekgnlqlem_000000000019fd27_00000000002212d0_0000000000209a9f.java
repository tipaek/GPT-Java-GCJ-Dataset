import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            char[] characters = inputString.toCharArray();
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < characters.length; i++) {
                if ((i == 0 && characters[i] == '1') || 
                    (i != 0 && characters[i - 1] == '0' && characters[i] == '1')) {
                    result.append("(");
                } else if (i != 0 && characters[i] == '0' && characters[i - 1] == '1') {
                    result.append(")");
                }
                
                result.append(characters[i]);
            }
            
            if (characters[characters.length - 1] == '1') {
                result.append(")");
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }
}