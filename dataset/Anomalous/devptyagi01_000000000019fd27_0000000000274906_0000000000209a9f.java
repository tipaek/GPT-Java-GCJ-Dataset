import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            for (char character : input.toCharArray()) {
                int digit = character - '0';
                
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }
                
                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                
                result.append(character);
            }
            
            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}