import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCaseIndex = 0; testCaseIndex < testCases; testCaseIndex++) {
            String inputString = scanner.next();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;
            
            for (int i = 0; i < inputString.length(); i++) {
                int digit = Character.getNumericValue(inputString.charAt(i));
                
                if (digit > currentDepth) {
                    int openBrackets = digit - currentDepth;
                    for (int j = 0; j < openBrackets; j++) {
                        output.append("(");
                    }
                    currentDepth = digit;
                } else if (digit < currentDepth) {
                    int closeBrackets = currentDepth - digit;
                    for (int j = 0; j < closeBrackets; j++) {
                        output.append(")");
                    }
                    currentDepth = digit;
                }
                
                output.append(digit);
            }
            
            for (int j = 0; j < currentDepth; j++) {
                output.append(")");
            }
            
            System.out.println("Case #" + (testCaseIndex + 1) + ": " + output);
        }
    }
}