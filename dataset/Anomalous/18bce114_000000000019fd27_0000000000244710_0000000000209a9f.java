import java.util.Scanner;

public class Solution {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int openBrackets = Character.getNumericValue(input.charAt(0));
            int closeBrackets = Character.getNumericValue(input.charAt(input.length() - 1));
            
            // Add initial open brackets
            for (int j = 0; j < openBrackets; j++) {
                result.append("(");
            }
            result.append(input.charAt(0));
            
            // Process the rest of the string
            for (int j = 0; j < input.length() - 1; j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int nextDigit = Character.getNumericValue(input.charAt(j + 1));
                
                if (currentDigit < nextDigit) {
                    for (int k = 0; k < nextDigit - currentDigit; k++) {
                        result.append("(");
                    }
                } else if (currentDigit > nextDigit) {
                    for (int k = 0; k < currentDigit - nextDigit; k++) {
                        result.append(")");
                    }
                }
                result.append(input.charAt(j + 1));
            }
            
            // Add closing brackets for the last character
            for (int j = 0; j < closeBrackets; j++) {
                result.append(")");
            }
            
            System.out.println(result.toString());
        }
        scanner.close();
    }
}