import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String digits = scanner.nextLine();
            StringBuilder[] parentheses = new StringBuilder[digits.length() + 1];
            
            // Initialize the array of StringBuilders
            for (int i = 0; i < parentheses.length; i++) {
                parentheses[i] = new StringBuilder();
            }
            
            // Add opening parentheses for the first digit
            int firstDigit = Character.getNumericValue(digits.charAt(0));
            for (int i = 0; i < firstDigit; i++) {
                parentheses[0].append('(');
            }
            
            // Process each pair of digits
            for (int i = 0; i < digits.length() - 1; i++) {
                int currentDigit = Character.getNumericValue(digits.charAt(i));
                int nextDigit = Character.getNumericValue(digits.charAt(i + 1));
                int diff = currentDigit - nextDigit;
                
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        parentheses[i + 1].append(')');
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        parentheses[i + 1].append('(');
                    }
                }
            }
            
            // Add closing parentheses for the last digit
            int lastDigit = Character.getNumericValue(digits.charAt(digits.length() - 1));
            for (int i = 0; i < lastDigit; i++) {
                parentheses[digits.length()].append(')');
            }
            
            // Build the final solution string
            StringBuilder solution = new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                solution.append(parentheses[i]);
                solution.append(digits.charAt(i));
            }
            solution.append(parentheses[digits.length()]);
            
            // Print the result for the current test case
            System.out.printf("Case #%d: %s\n", caseNum, solution);
        }
        
        scanner.close();
    }
}